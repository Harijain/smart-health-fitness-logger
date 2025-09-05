package com.villain.healthtracker.repository;

import com.villain.healthtracker.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
