package com.villain.healthtracker.service;

import com.villain.healthtracker.exception.ResourceNotFoundException;
import com.villain.healthtracker.model.Sleep;
import com.villain.healthtracker.repository.SleepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SleepService {

    @Autowired
    private SleepRepository repo;

    public Sleep saveSleep(Sleep sleep) {
        return repo.save(sleep);
    }

    public List<Sleep> getSleepByUserId(String userId) {
        return repo.findByUserId(userId);
    }

    public void deleteSleep(String id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Sleep record not found with id: " + id);
        }
        repo.deleteById(id);
    }
}
