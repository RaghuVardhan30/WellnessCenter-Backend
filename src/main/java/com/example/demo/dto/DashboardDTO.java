package com.example.demo.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardDTO {

    private int score;
    private double sleepHours;
    private double hydration;
    private int energy;
    private String activity;
}
