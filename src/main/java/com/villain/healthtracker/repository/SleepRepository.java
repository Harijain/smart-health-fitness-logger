package com.villain.healthtracker.repository;

import com.villain.healthtracker.model.Sleep; // if package differs, correct it
import com.villain.healthtracker.model.Sleep;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface SleepRepository extends MongoRepository<Sleep, String> {
    List<Sleep> findByUserId(String userId);
}
