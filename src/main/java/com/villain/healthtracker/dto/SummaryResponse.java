package com.villain.healthtracker.dto;

public class SummaryResponse {
    private String userId;
    private int dailyCaloriesTarget;
    private String goalType;
    private double netCalories;

    // Getters and Setters
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public int getDailyCaloriesTarget() {
        return dailyCaloriesTarget;
    }
    public void setDailyCaloriesTarget(int dailyCaloriesTarget) {
        this.dailyCaloriesTarget = dailyCaloriesTarget;
    }
    public String getGoalType() {
        return goalType;
    }
    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }
    public double getNetCalories() {
        return netCalories;
    }
    public void setNetCalories(double netCalories) {
        this.netCalories = netCalories;
    }
}

