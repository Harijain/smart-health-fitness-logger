package com.villain.healthtracker.service;

import com.villain.healthtracker.exception.ResourceNotFoundException;
import com.villain.healthtracker.model.Goal;
import com.villain.healthtracker.repository.GoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    @Autowired
    private GoalRepository repo;

    public Goal saveGoal(Goal goal) {
        return repo.save(goal);
    }

    public Goal getGoalByUserId(String userId) {
        return repo.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Goal not found for userId: " + userId));
    }

    public void deleteGoal(String id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Goal not found with id: " + id);
        }
        repo.deleteById(id);
    }
}
