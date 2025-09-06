package com.villain.healthtracker.repository;

import com.villain.healthtracker.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FoodRepository extends MongoRepository<Food, String> {
}
