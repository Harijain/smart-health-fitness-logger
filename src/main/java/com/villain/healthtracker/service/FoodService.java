package com.villain.healthtracker.service;

import com.villain.healthtracker.exception.ResourceNotFoundException;
import com.villain.healthtracker.model.Food;
import com.villain.healthtracker.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {

    @Autowired
    private FoodRepository foodRepo;

    // Save food
    public Food saveFood(Food food) {
        return foodRepo.save(food);
    }

    // Get all foods by UserId
    public List<Food> getFoodsByUserId(String userId) {
        return foodRepo.findByUserId(userId);
    }

    // Get single food by Id
    public Food getFoodById(String id) {
        return foodRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food not found with id: " + id));
    }

    // Update food
    public Food updateFood(String id, Food updatedFood) {
        return foodRepo.findById(id).map(food -> {
            food.setName(updatedFood.getName());
            food.setCalories(updatedFood.getCalories());
            return foodRepo.save(food);
        }).orElseThrow(() -> new ResourceNotFoundException("Food not found with id: " + id));
    }

    // Delete food
    public void deleteFood(String id) {
        if (foodRepo.existsById(id)) {
            foodRepo.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Food not found with id: " + id);
        }
    }
}
