package com.villain.healthtracker.repository;

import com.villain.healthtracker.model.Exercise;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExerciseRepository extends MongoRepository<Exercise, String> {
    List<Exercise> findByUserId(String userId);
}
