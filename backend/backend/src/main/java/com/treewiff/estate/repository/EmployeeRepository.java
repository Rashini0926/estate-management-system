package com.treewiff.estate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.treewiff.estate.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
