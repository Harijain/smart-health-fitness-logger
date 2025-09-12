package com.villain.healthtracker.service;

import com.villain.healthtracker.model.Exercise;
import com.villain.healthtracker.model.Food;
import com.villain.healthtracker.model.Goal;
import com.villain.healthtracker.model.Summary;
import com.villain.healthtracker.repository.ExerciseRepository;
import com.villain.healthtracker.repository.FoodRepository;
import com.villain.healthtracker.repository.GoalRepository; // if wrong remove
import com.villain.healthtracker.repository.GoalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SummaryService {

    @Autowired
    private FoodRepository foodRepo;

    @Autowired
    private ExerciseRepository exerciseRepo;

    @Autowired
    private GoalRepository goalRepo;

    public Summary getUserSummary(String userId) {
        // safe fetch lists (repo returns empty list if none)
        List<Food> foods = foodRepo.findByUserId(userId);
        if (foods == null) foods = Collections.emptyList();

        List<Exercise> exercises = exerciseRepo.findByUserId(userId);
        if (exercises == null) exercises = Collections.emptyList();

        // Goal may be absent
        Optional<Goal> goalOpt = goalRepo.findByUserId(userId);
        Goal goal = goalOpt.orElse(null);

        double totalCaloriesConsumed = foods.stream()
                                           .mapToDouble(f -> f.getCalories())
                                           .sum();

        double totalCaloriesBurned = exercises.stream()
                                              .mapToDouble(e -> e.getCaloriesBurned())
                                              .sum();

        double netCalories = totalCaloriesConsumed - totalCaloriesBurned;

        Summary summary = new Summary();
        summary.setUserId(userId);
        summary.setCaloriesConsumed(totalCaloriesConsumed);
        summary.setCaloriesBurned(totalCaloriesBurned);
        summary.setNetCalories(netCalories);

        if (goal != null) {
            summary.setGoalType(goal.getGoalType());
            summary.setTargetCalories(goal.getDailyCaloriesTarget());
        }

        return summary;
    }
}
