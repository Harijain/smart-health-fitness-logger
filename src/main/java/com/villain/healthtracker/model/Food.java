package com.villain.healthtracker.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "foods")
public class Food {

    @Id
    private String id;

    @NotBlank(message = "UserId is required")
    private String userId;

    @NotBlank(message = "Food name is required")
    private String name;

    @Positive(message = "Calories must be positive")
    private double calories;

    public Food() {}

    public Food(String userId, String name, double calories) {
        this.userId = userId;
        this.name = name;
        this.calories = calories;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getCalories() { return calories; }
    public void setCalories(double calories) { this.calories = calories; }
}
