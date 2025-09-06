package com.villain.healthtracker.controller;

import com.villain.healthtracker.model.Food;
import com.villain.healthtracker.repository.FoodRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foods")
public class FoodController {

    private final FoodRepository foodRepository;

    public FoodController(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @GetMapping
    public List<Food> getAllFoods() {
        return foodRepository.findAll();
    }

    @PostMapping
    public Food createFood(@RequestBody Food food) {
        return foodRepository.save(food);
    }
}
