package com.villain.healthtracker.repository;

import com.villain.healthtracker.model.Goal;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GoalRepository extends MongoRepository<Goal, String> {
}
