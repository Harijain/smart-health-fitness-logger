package com.villain.healthtracker.controller;

import com.villain.healthtracker.model.Exercise;
import com.villain.healthtracker.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exercises")
public class ExerciseController {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @PostMapping
    public Exercise addExercise(@RequestBody Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @GetMapping("/{userId}")
    public List<Exercise> getExercisesByUser(@PathVariable String userId) {
        return exerciseRepository.findByUserId(userId);
    }
}
