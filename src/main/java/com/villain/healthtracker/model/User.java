package com.villain.healthtracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String name;
    private Integer age;
    private Double weightKg;
    private Double heightCm;
    private String gender; // "male" or "female"
    private String activityLevel; // "LOW" | "MEDIUM" | "HIGH"
    private String goalType; // "LOSE" | "GAIN" | "MAINTAIN"
    private Double targetWeightKg; // optional
    private Integer targetCalories; // optional, can be filled by recommendation endpoint

    public User() {}

    // getters & setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }

    public Double getWeightKg() { return weightKg; }
    public void setWeightKg(Double weightKg) { this.weightKg = weightKg; }

    public Double getHeightCm() { return heightCm; }
    public void setHeightCm(Double heightCm) { this.heightCm = heightCm; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getActivityLevel() { return activityLevel; }
    public void setActivityLevel(String activityLevel) { this.activityLevel = activityLevel; }

    public String getGoalType() { return goalType; }
    public void setGoalType(String goalType) { this.goalType = goalType; }

    public Double getTargetWeightKg() { return targetWeightKg; }
    public void setTargetWeightKg(Double targetWeightKg) { this.targetWeightKg = targetWeightKg; }

    public Integer getTargetCalories() { return targetCalories; }
    public void setTargetCalories(Integer targetCalories) { this.targetCalories = targetCalories; }
}
