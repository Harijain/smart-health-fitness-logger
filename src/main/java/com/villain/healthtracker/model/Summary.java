package com.villain.healthtracker.model;

public class Summary {
    private String userId;
    private double caloriesConsumed;
    private double caloriesBurned;
    private double netCalories;
    private String goalType;
    private Integer targetCalories;

    public Summary() {}

    // Getters & Setters
    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public double getCaloriesConsumed() { return caloriesConsumed; }
    public void setCaloriesConsumed(double caloriesConsumed) { this.caloriesConsumed = caloriesConsumed; }

    public double getCaloriesBurned() { return caloriesBurned; }
    public void setCaloriesBurned(double caloriesBurned) { this.caloriesBurned = caloriesBurned; }

    public double getNetCalories() { return netCalories; }
    public void setNetCalories(double netCalories) { this.netCalories = netCalories; }

    public String getGoalType() { return goalType; }
    public void setGoalType(String goalType) { this.goalType = goalType; }

    public Integer getTargetCalories() { return targetCalories; }
    public void setTargetCalories(Integer targetCalories) { this.targetCalories = targetCalories; }
}
