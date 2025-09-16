package com.villain.healthtracker.controller;

import com.villain.healthtracker.model.Food;
import com.villain.healthtracker.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("/api/foods")
public class FoodController {

    @Autowired
    private FoodService foodService;

    // Create food
    @PostMapping
    public Food createFood(@RequestBody Food food) {
        return foodService.saveFood(food);
    }

    // Get all foods for a user
    @GetMapping("/user/{userId}")
    public List<Food> getFoodsByUser(@PathVariable String userId) {
        return foodService.getFoodsByUserId(userId);
    }

    // Get food by id
    @GetMapping("/{id}")
    public Food getFoodById(@PathVariable String id) {
        return foodService.getFoodById(id);
    }

    // Update food
    @PutMapping("/{id}")
    public Food updateFood(@PathVariable String id, @RequestBody Food food) {
        return foodService.updateFood(id, food);
    }

    // Delete food
    @DeleteMapping("/{id}")
    public String deleteFood(@PathVariable String id) {
        foodService.deleteFood(id);
        return "Food with id " + id + " deleted successfully.";
    }
}
