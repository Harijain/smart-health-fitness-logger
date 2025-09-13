package com.villain.healthtracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "summaries")
public class Summary {

    @Id
    private String id;

    private String userId;
    private double caloriesConsumed;
    private double caloriesBurned;
    private double netCalories;
    private int totalSleepHours;   // ✅ New field
    private String goalType;
    private double targetCalories;

    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getCaloriesConsumed() {
        return caloriesConsumed;
    }

    public void setCaloriesConsumed(double caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public double getNetCalories() {
        return netCalories;
    }

    public void setNetCalories(double netCalories) {
        this.netCalories = netCalories;
    }

    public int getTotalSleepHours() {
        return totalSleepHours;
    }

    public void setTotalSleepHours(int totalSleepHours) {
        this.totalSleepHours = totalSleepHours;
    }

    public String getGoalType() {
        return goalType;
    }

    public void setGoalType(String goalType) {
        this.goalType = goalType;
    }

    public double getTargetCalories() {
        return targetCalories;
    }

    public void setTargetCalories(double targetCalories) {
        this.targetCalories = targetCalories;
    }
}
