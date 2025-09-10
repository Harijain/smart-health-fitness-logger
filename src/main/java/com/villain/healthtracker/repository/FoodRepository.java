package com.villain.healthtracker.repository;

import com.villain.healthtracker.model.Food;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface FoodRepository extends MongoRepository<Food, String> {
    List<Food> findByUserId(String userId);  // 👈 Add this line
}
