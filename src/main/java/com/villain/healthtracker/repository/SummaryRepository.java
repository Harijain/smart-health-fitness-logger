package com.villain.healthtracker.repository;

import com.villain.healthtracker.model.Summary;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface SummaryRepository extends MongoRepository<Summary, String> {

    // ✅ userId is String
    List<Summary> findByUserId(String userId);
}
