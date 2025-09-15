package com.villain.healthtracker.service;

import com.villain.healthtracker.exception.ResourceNotFoundException;
import com.villain.healthtracker.model.Exercise;
import com.villain.healthtracker.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository repo;

    public Exercise saveExercise(Exercise exercise) {
        return repo.save(exercise);
    }

    public List<Exercise> getExercisesByUserId(String userId) {
        return repo.findByUserId(userId);
    }

    public void deleteExercise(String id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Exercise not found with id: " + id);
        }
        repo.deleteById(id);
    }
}
