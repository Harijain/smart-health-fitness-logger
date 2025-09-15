package com.villain.healthtracker.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data  //  Lombok: generates getters, setters, toString, equals, hashCode
@NoArgsConstructor  //  default constructor
@AllArgsConstructor //  all-args constructor
@Document(collection = "foods")
public class Food {

    @Id
    private String id;

    @NotBlank(message = "User ID is required")
    private String userId;

    @NotBlank(message = "Food name is required")
    private String name;

    @Positive(message = "Calories must be a positive number")
    private double calories;
}
