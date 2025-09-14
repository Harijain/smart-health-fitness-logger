package com.villain.healthtracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "summaries")
public class Summary {

    @Id
    private String id;  // ✅ String instead of Long

    private String userId;  // ✅ keep as String

    private int caloriesConsumed;
    private int caloriesBurned;
    private int netCalories;
    private int totalSleepHours;

    private String goalType;       // Example: LOSE, GAIN, MAINTAIN
    private int targetCalories;

    // ✅ Getters and Setters
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

    public int getCaloriesConsumed() {
        return caloriesConsumed;
    }
    public void setCaloriesConsumed(int caloriesConsumed) {
        this.caloriesConsumed = caloriesConsumed;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }
    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public int getNetCalories() {
        return netCalories;
    }
    public void setNetCalories(int netCalories) {
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

    public int getTargetCalories() {
        return targetCalories;
    }
    public void setTargetCalories(int targetCalories) {
        this.targetCalories = targetCalories;
    }
}
