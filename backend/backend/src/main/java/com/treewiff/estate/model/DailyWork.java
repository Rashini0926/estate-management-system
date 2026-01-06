package com.treewiff.estate.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class DailyWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private String task;
    private String fields;
    private double kg;
    private double salary;

    @ManyToOne
    private Employee employee;

    public Long getId() { return id; }
    public LocalDate getDate() { return date; }
    public String getTask() { return task; }
    public String getFields() { return fields; }
    public double getKg() { return kg; }
    public double getSalary() { return salary; }
    public Employee getEmployee() { return employee; }

    public void setDate(LocalDate date) { this.date = date; }
    public void setTask(String task) { this.task = task; }
    public void setFields(String fields) { this.fields = fields; }
    public void setKg(double kg) { this.kg = kg; }
    public void setSalary(double salary) { this.salary = salary; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}
