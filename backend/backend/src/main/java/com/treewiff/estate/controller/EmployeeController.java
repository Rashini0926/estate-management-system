package com.treewiff.estate.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import com.treewiff.estate.model.Employee;
import com.treewiff.estate.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin
public class EmployeeController {

    @Autowired
    private EmployeeRepository repo;

    @GetMapping
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @PostMapping
    public Employee save(@RequestBody Employee e) {
        return repo.save(e);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
