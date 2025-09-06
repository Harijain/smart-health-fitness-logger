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
    private String gender; // male/female/other
    private String activityLevel; // sedentary/light/moderate/active
    private String goal; // lose/gain/maintain
    private Integer targetCalories; // optional calculated field

    public User() {}

    public User(String name, Integer age, Double weightKg, Double heightCm, String gender, String activityLevel, String goal) {
        this.name = name;
        this.age = age;
        this.weightKg = weightKg;
        this.heightCm = heightCm;
        this.gender = gender;
        this.activityLevel = activityLevel;
        this.goal = goal;
    }

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

    public String getGoal() { return goal; }
    public void setGoal(String goal) { this.goal = goal; }

    public Integer getTargetCalories() { return targetCalories; }
    public void setTargetCalories(Integer targetCalories) { this.targetCalories = targetCalories; }
}
