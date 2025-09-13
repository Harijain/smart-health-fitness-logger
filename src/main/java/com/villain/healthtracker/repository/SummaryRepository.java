package com.villain.healthtracker.repository;

import com.villain.healthtracker.model.Summary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummaryRepository extends MongoRepository<Summary, String> {
}
