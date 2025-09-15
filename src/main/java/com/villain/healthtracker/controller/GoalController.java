package com.villain.healthtracker.controller;

import com.villain.healthtracker.model.Goal;
import com.villain.healthtracker.service.GoalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/goal")
public class GoalController {

    @Autowired
    private GoalService service;

    @PostMapping
    public ResponseEntity<Goal> addGoal(@RequestBody Goal goal) {
        return ResponseEntity.ok(service.saveGoal(goal));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Goal> getGoal(@PathVariable String userId) {
        return ResponseEntity.ok(service.getGoalByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteGoal(@PathVariable String id) {
        service.deleteGoal(id);
        return ResponseEntity.ok("Goal deleted successfully");
    }
}
