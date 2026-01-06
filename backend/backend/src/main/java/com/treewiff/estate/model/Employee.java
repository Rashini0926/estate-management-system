package com.treewiff.estate.model;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    public Employee() {}

    public Employee(String name, EmployeeType type) {
        this.name = name;
        this.type = type;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public EmployeeType getType() { return type; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setType(EmployeeType type) { this.type = type; }
}
