package com.treewiff.estate.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.*;
import java.util.*;

import com.treewiff.estate.model.*;
import com.treewiff.estate.repository.*;
import com.treewiff.estate.service.*;
import com.treewiff.estate.dto.WeeklySalaryDTO;

@RestController
@RequestMapping("/api/work")
@CrossOrigin
public class DailyWorkController {

    @Autowired
    private DailyWorkService service;

    @Autowired
    private DailyWorkRepository repo;

    @PostMapping
    public DailyWork save(@RequestBody DailyWork work) {
        return service.save(work);
    }

    @GetMapping("/weekly")
    public List<WeeklySalaryDTO> weeklySummary() {

        Map<String, Map<String, Double>> map = new HashMap<>();

        for (DailyWork w : repo.findAll()) {
            LocalDate d = w.getDate();
            LocalDate sat = d.plusDays(6 - d.getDayOfWeek().getValue());
            String week = sat.toString();

            map.putIfAbsent(week, new HashMap<>());
            map.get(week).merge(
                    w.getEmployee().getName(),
                    w.getSalary(),
                    Double::sum
            );
        }

        List<WeeklySalaryDTO> list = new ArrayList<>();
        map.forEach((week, empMap) ->
                empMap.forEach((emp, sal) ->
                        list.add(new WeeklySalaryDTO(week, emp, sal))
                )
        );

        return list;
    }
}
