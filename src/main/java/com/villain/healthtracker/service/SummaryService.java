package com.villain.healthtracker.service;

import com.villain.healthtracker.model.Exercise;
import com.villain.healthtracker.model.Food;
import com.villain.healthtracker.model.Goal;
import com.villain.healthtracker.model.Sleep;
import com.villain.healthtracker.model.Summary;
import com.villain.healthtracker.repository.ExerciseRepository;
import com.villain.healthtracker.repository.FoodRepository;
import com.villain.healthtracker.repository.GoalRepository;
import com.villain.healthtracker.repository.SleepRepository;
import com.villain.healthtracker.repository.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Autowired
    private SleepRepository sleepRepo;

    @Autowired
    private SummaryRepository summaryRepo;

    // ✅ Save summary (manual entry)
    public Summary saveSummary(Summary summary) {
        return summaryRepo.save(summary);
    }

    // ✅ Auto calculate summary
    public Summary getUserSummary(String userId) {
        List<Food> foods = foodRepo.findByUserId(userId);
        List<Exercise> exercises = exerciseRepo.findByUserId(userId);
        List<Sleep> sleeps = sleepRepo.findByUserId(userId);
        Optional<Goal> goalOpt = goalRepo.findByUserId(userId);

        double totalCaloriesConsumed = foods.stream().mapToDouble(Food::getCalories).sum();
        double totalCaloriesBurned = exercises.stream().mapToDouble(Exercise::getCaloriesBurned).sum();
        int totalSleepHours = sleeps.stream().mapToInt(Sleep::getDurationHours).sum();

        double netCalories = totalCaloriesConsumed - totalCaloriesBurned;

        Summary summary = new Summary();
        summary.setUserId(userId);
        summary.setCaloriesConsumed(totalCaloriesConsumed);
        summary.setCaloriesBurned(totalCaloriesBurned);
        summary.setNetCalories(netCalories);
        summary.setTotalSleepHours(totalSleepHours);

        goalOpt.ifPresent(goal -> {
            summary.setGoalType(goal.getGoalType());
            summary.setTargetCalories(goal.getDailyCaloriesTarget());
        });

        return summary;
    }

    // ✅ Update summary (by ID)
    public Optional<Summary> updateSummary(String id, Summary updatedSummary) {
        return summaryRepo.findById(id).map(existing -> {
            existing.setCaloriesConsumed(updatedSummary.getCaloriesConsumed());
            existing.setCaloriesBurned(updatedSummary.getCaloriesBurned());
            existing.setNetCalories(updatedSummary.getNetCalories());
            existing.setTotalSleepHours(updatedSummary.getTotalSleepHours());
            existing.setGoalType(updatedSummary.getGoalType());
            existing.setTargetCalories(updatedSummary.getTargetCalories());
            return summaryRepo.save(existing);
        });
    }

    // ✅ Delete summary (by ID)
    public void deleteSummary(String id) {
        if (summaryRepo.existsById(id)) {
            summaryRepo.deleteById(id);
        } else {
            throw new RuntimeException("Summary not found with id: " + id);
        }
    }
}
