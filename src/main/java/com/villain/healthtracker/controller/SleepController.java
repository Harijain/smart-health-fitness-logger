package com.villain.healthtracker.controller;

import com.villain.healthtracker.model.Sleep;
import com.villain.healthtracker.service.SleepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sleep")
public class SleepController {

    @Autowired
    private SleepService service;

    @PostMapping
    public ResponseEntity<Sleep> addSleep(@RequestBody Sleep sleep) {
        return ResponseEntity.ok(service.saveSleep(sleep));
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Sleep>> getSleepRecords(@PathVariable String userId) {
        return ResponseEntity.ok(service.getSleepByUserId(userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSleep(@PathVariable String id) {
        service.deleteSleep(id);
        return ResponseEntity.ok("Sleep record deleted successfully");
    }
}
