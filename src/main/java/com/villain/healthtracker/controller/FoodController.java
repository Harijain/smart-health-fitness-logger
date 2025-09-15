package com.villain.healthtracker.controller;

import com.villain.healthtracker.model.Food;
import com.villain.healthtracker.service.FoodService;
import com.villain.healthtracker.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")  //  Important
public class FoodController {

    @Autowired
    private FoodService foodService;

    //  Add food
    @PostMapping
    public Food createFood(@RequestBody Food food) {
        return foodService.saveFood(food);
    }

    //  Get all foods by userId
    @GetMapping("/user/{userId}")
    public List<Food> getFoodsByUser(@PathVariable String userId) {
        return foodService.getFoodsByUserId(userId);
    }

    //  Get food by id
    @GetMapping("/{id}")
    public ResponseEntity<Food> getFoodById(@PathVariable String id) {
        Food food = foodService.getFoodById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id: " + id));
        return ResponseEntity.ok(food);
    }

    // ✅ Delete food
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFood(@PathVariable String id) {
        foodService.deleteFood(id);
        return ResponseEntity.noContent().build();
    }
}
