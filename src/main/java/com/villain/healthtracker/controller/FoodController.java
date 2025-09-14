package com.villain.healthtracker.controller;

import com.villain.healthtracker.model.Food;
import com.villain.healthtracker.repository.FoodRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/food")
public class FoodController {

    @Autowired
    private FoodRepository foodRepo;

    @PostMapping
    public ResponseEntity<Food> createFood(@Valid @RequestBody Food food) {
        return ResponseEntity.ok(foodRepo.save(food));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Food>> getFoods(@PathVariable String userId) {
        return ResponseEntity.ok(foodRepo.findByUserId(userId));
    }
}
