package com.villain.healthtracker.service;

import com.villain.healthtracker.model.Exercise;
import com.villain.healthtracker.model.Food;
import com.villain.healthtracker.model.Goal;
import com.villain.healthtracker.model.Summary;
import com.villain.healthtracker.repository.ExerciseRepository;
import com.villain.healthtracker.repository.FoodRepository;
import com.villain.healthtracker.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryService {

    @Autowired
    private FoodRepository foodRepo;

    @Autowired
    private ExerciseRepository exerciseRepo;

    @Autowired
    private GoalRepository goalRepo; // ✅ correct variable name

    public Summary getUserSummary(String userId) {
        // User ke foods, exercises, goals nikal lo
        List<Food> foods = foodRepo.findByUserId(userId);
        List<Exercise> exercises = exerciseRepo.findByUserId(userId);
        Goal goal = goalRepo.findByUserId(userId).orElse(null);

        double totalCaloriesConsumed = 0;
        double totalCaloriesBurned = 0;

        for (Food food : foods) {
            totalCaloriesConsumed += food.getCalories();
        }

        for (Exercise ex : exercises) {
            totalCaloriesBurned += ex.getCaloriesBurned();
        }

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
