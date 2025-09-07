package com.villain.healthtracker.controller;

import com.villain.healthtracker.model.User;
import com.villain.healthtracker.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class GoalController {

    private final UserRepository userRepository;

    public GoalController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Returns calorie & macro recommendation for a user.
     * - uses Mifflin-St Jeor BMR
     * - activity multiplier: LOW=1.2, MEDIUM=1.55, HIGH=1.725
     * - goal adjustment: LOSE -> -500, GAIN -> +400, MAINTAIN -> +0
     * - macros: protein 30%, carbs 45%, fat 25%
     */
    @GetMapping("/{id}/recommendation")
    public ResponseEntity<?> recommend(@PathVariable String id) {
        Optional<User> opt = userRepository.findById(id);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();

        User u = opt.get();

        // Basic validations
        if (u.getAge() == null || u.getWeightKg() == null || u.getHeightCm() == null || u.getGender() == null) {
            return ResponseEntity.badRequest()
                    .body(Map.of("error", "user must have age, weightKg, heightCm, and gender set"));
        }

        double weight = u.getWeightKg();
        double height = u.getHeightCm();
        int age = u.getAge();
        String gender = u.getGender().toLowerCase();
        String activity = (u.getActivityLevel() == null) ? "LOW" : u.getActivityLevel().toUpperCase();
        String goal = (u.getGoalType() == null) ? "MAINTAIN" : u.getGoalType().toUpperCase();

        // Mifflin-St Jeor BMR
        // men: BMR = 10*w + 6.25*h - 5*age + 5
        // women: BMR = 10*w + 6.25*h - 5*age - 161
        double bmr;
        if (gender.startsWith("m")) {
            bmr = 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        }

        // Activity multiplier
        double multiplier = switch (activity) {
            case "HIGH" -> 1.725;
            case "MEDIUM" -> 1.55;
            default -> 1.2; // LOW
        };

        double tdee = bmr * multiplier; // maintenance calories

        // Goal adjustments
        double recommended = switch (goal) {
            case "LOSE" -> tdee - 500;     // typical deficit
            case "GAIN" -> tdee + 400;     // typical surplus
            default -> tdee;               // maintain
        };

        // ensure recommended not ridiculously low
        if (recommended < 1200) recommended = 1200;

        // Macros split
        double calProtein = recommended * 0.30;
        double calCarbs = recommended * 0.45;
        double calFat = recommended * 0.25;

        double gramsProtein = calProtein / 4.0;
        double gramsCarbs = calCarbs / 4.0;
        double gramsFat = calFat / 9.0;

        // Round values a bit
        int recCalories = (int)Math.round(recommended);
        int recProteinG = (int)Math.round(gramsProtein);
        int recCarbsG = (int)Math.round(gramsCarbs);
        int recFatG = (int)Math.round(gramsFat);

        // Save targetCalories to user (optional)
        u.setTargetCalories(recCalories);
        userRepository.save(u);

        Map<String, Object> resp = Map.of(
                "userId", u.getId(),
                "name", u.getName(),
                "goal", goal,
                "maintenanceCalories", (int)Math.round(tdee),
                "recommendedCalories", recCalories,
                "macros", Map.of(
                        "protein_g", recProteinG,
                        "carbs_g", recCarbsG,
                        "fat_g", recFatG
                )
        );

        return ResponseEntity.ok(resp);
    }
}

