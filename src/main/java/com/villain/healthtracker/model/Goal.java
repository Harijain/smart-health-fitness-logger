package com.villain.healthtracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "goals")
public class Goal {
    @Id
    private String id;

    private String userId;
    private int dailyCaloriesTarget;
    private String goalType; // LOSE / GAIN / MAINTAIN

    public Goal() {}

    public Goal(String userId, int dailyCaloriesTarget, String goalType) {
        this.userId = userId;
        this.dailyCaloriesTarget = dailyCaloriesTarget;
        this.goalType = goalType;
    }

    public String getId() {
        return id;
    }

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
}
