package com.villain.healthtracker.controller;

import com.villain.healthtracker.model.Goal;
import com.villain.healthtracker.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/goals")
public class GoalController {

    @Autowired
    private GoalRepository goalRepository;

    @PostMapping
    public Goal createGoal(@RequestBody Goal goal) {
        return goalRepository.save(goal);
    }

    @GetMapping("/{userId}")
    public List<Goal> getGoalsByUser(@PathVariable String userId) {
        return goalRepository.findAll()
                .stream()
                .filter(g -> g.getUserId().equals(userId))
                .toList();
    }
}
