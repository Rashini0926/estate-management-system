package com.treewiff.estate.dto;

public class WeeklySalaryDTO {

    private String weekEnding;
    private String employeeName;
    private double totalSalary;

    public WeeklySalaryDTO(String w, String e, double s) {
        this.weekEnding = w;
        this.employeeName = e;
        this.totalSalary = s;
    }

    public String getWeekEnding() { return weekEnding; }
    public String getEmployeeName() { return employeeName; }
    public double getTotalSalary() { return totalSalary; }
}
