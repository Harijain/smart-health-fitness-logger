package com.villain.healthtracker.controller;

import com.villain.healthtracker.model.Exercise;
import com.villain.healthtracker.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseService service;

    @PostMapping
    public ResponseEntity<Exercise> addExercise(@RequestBody Exercise exercise) {
        return ResponseEntity.ok(service.saveExercise(exercise));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Exercise>> getExercises(@PathVariable String userId) {
        return ResponseEntity.ok(service.getExercisesByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExercise(@PathVariable String id) {
        service.deleteExercise(id);
        return ResponseEntity.ok("Exercise deleted successfully");
    }
}
