package com.villain.healthtracker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "sleeps")
public class Sleep {
    @Id
    private String id;
    private String userId;
    private int durationHours;
    private String date; // optional: you can store date of sleep record

    public Sleep() {}

    public Sleep(String userId, int durationHours, String date) {
        this.userId = userId;
        this.durationHours = durationHours;
        this.date = date;
    }

    // Getters & Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public int getDurationHours() { return durationHours; }
    public void setDurationHours(int durationHours) { this.durationHours = durationHours; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }
}
