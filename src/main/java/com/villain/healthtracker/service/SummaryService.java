package com.villain.healthtracker.service;

import com.villain.healthtracker.dto.SummaryResponse;
import com.villain.healthtracker.model.Goal;
import com.villain.healthtracker.model.Food;
import com.villain.healthtracker.model.Exercise;
import com.villain.healthtracker.repository.GoalRepository;
import com.villain.healthtracker.repository.FoodRepository;
import com.villain.healthtracker.repository.ExerciseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SummaryService {

    @Autowired
    private GoalRepository goalRepo;

    @Autowired
    private FoodRepository foodRepo;

    @Autowired
    private ExerciseRepository exerciseRepo;

    public SummaryResponse getUserSummary(String userId) {
        // Step 1: Goal fetch with safety
        Goal goal = goalRepo.findByUserId(userId).orElse(null);
        if (goal == null) {
            throw new RuntimeException("Goal not set for user: " + userId);
        }

        // Step 2: Food list safe fetch
        List<Food> foods = foodRepo.findByUserId(userId);
        if (foods == null) {
            foods = new ArrayList<>();
        }

        // Step 3: Exercise list safe fetch
        List<Exercise> exercises = exerciseRepo.findByUserId(userId);
        if (exercises == null) {
            exercises = new ArrayList<>();
        }

        // Step 4: Calculate totals
        double totalCalories = foods.stream().mapToDouble(Food::getCalories).sum()
                - exercises.stream().mapToDouble(Exercise::getCaloriesBurned).sum();

        // Step 5: Build response
        SummaryResponse response = new SummaryResponse();
        response.setUserId(userId);
        response.setDailyCaloriesTarget(goal.getDailyCaloriesTarget());
        response.setGoalType(goal.getGoalType());
        response.setNetCalories(totalCalories);

        return response;
    }
}
