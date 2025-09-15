package com.villain.healthtracker.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "sleeps")
public class Sleep {

    @Id
    private String id;

    @NotBlank(message = "User ID is required")
    private String userId;

    @Positive(message = "Duration must be positive")
    private int durationHours;
}
