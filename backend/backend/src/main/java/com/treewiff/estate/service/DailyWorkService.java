package com.treewiff.estate.service;

import com.treewiff.estate.model.*;
import com.treewiff.estate.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DailyWorkService {

    @Autowired
    private RateRepository rateRepo;

    @Autowired
    private DailyWorkRepository workRepo;

    public DailyWork save(DailyWork work) {

        String month = work.getDate().toString().substring(0,7);

        Rate rate = rateRepo.findByMonth(month)
                .orElseThrow(() -> new RuntimeException("Rate not found"));

        double salary;

        if (work.getTask().startsWith("Plucking")) {
            salary = work.getKg() *
                    (work.getEmployee().getType() == EmployeeType.SENIOR ?
                            rate.getPluckingSenior() :
                            rate.getPluckingNormal());
        } else {
            salary = work.getEmployee().getType() == EmployeeType.SENIOR ?
                    rate.getDailySenior() :
                    rate.getDailyNormal();
        }

        work.setSalary(salary);
        return workRepo.save(work);
    }
}
