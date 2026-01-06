package com.treewiff.estate.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.treewiff.estate.model.Rate;
import com.treewiff.estate.repository.RateRepository;

@RestController
@RequestMapping("/api/rates")
@CrossOrigin
public class RateController {

    @Autowired
    private RateRepository repo;

    @PostMapping
    public Rate save(@RequestBody Rate r) {
        return repo.save(r);
    }

    @GetMapping
    public List<Rate> getAll() {
        return repo.findAll();
    }
}
