package com.treewiff.estate.model;

import jakarta.persistence.*;

@Entity
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String month;

    private double pluckingSenior;
    private double pluckingNormal;
    private double dailySenior;
    private double dailyNormal;

    public Long getId() { return id; }
    public String getMonth() { return month; }

    public double getPluckingSenior() { return pluckingSenior; }
    public double getPluckingNormal() { return pluckingNormal; }
    public double getDailySenior() { return dailySenior; }
    public double getDailyNormal() { return dailyNormal; }

    public void setMonth(String month) { this.month = month; }
    public void setPluckingSenior(double v) { this.pluckingSenior = v; }
    public void setPluckingNormal(double v) { this.pluckingNormal = v; }
    public void setDailySenior(double v) { this.dailySenior = v; }
    public void setDailyNormal(double v) { this.dailyNormal = v; }
}
