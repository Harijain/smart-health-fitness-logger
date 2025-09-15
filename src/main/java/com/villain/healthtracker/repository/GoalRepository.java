package com.villain.healthtracker.repository;

import com.villain.healthtracker.model.Goal;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface GoalRepository extends MongoRepository<Goal, String> {
    Optional<Goal> findByUserId(String userId);
}
