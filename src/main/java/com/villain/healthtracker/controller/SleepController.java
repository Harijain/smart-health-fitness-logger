package com.villain.healthtracker.controller;

import com.villain.healthtracker.model.Sleep;
import com.villain.healthtracker.repository.SleepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sleep")
public class SleepController {

    @Autowired
    private SleepRepository sleepRepo;

    // POST - Save sleep entry
    @PostMapping
    public Sleep addSleep(@RequestBody Sleep sleep) {
        return sleepRepo.save(sleep);
    }

    // GET - Fetch all sleep logs for a user
    @GetMapping("/{userId}")
    public List<Sleep> getSleepByUser(@PathVariable String userId) {
        return sleepRepo.findByUserId(userId);
    }
}
