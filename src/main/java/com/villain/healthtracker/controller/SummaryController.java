package com.villain.healthtracker.controller;

import com.villain.healthtracker.exception.ResourceNotFoundException;
import com.villain.healthtracker.model.Summary;
import com.villain.healthtracker.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/summary")
public class SummaryController {

    @Autowired
    private SummaryService summaryService;

    // ✅ POST (Save summary manually)
    @PostMapping
    public ResponseEntity<Summary> createSummary(@RequestBody Summary summary) {
        Summary savedSummary = summaryService.saveSummary(summary);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedSummary);
    }

    // ✅ GET (Get auto-calculated summary by userId)
    @GetMapping("/{userId}")
    public ResponseEntity<Summary> getSummary(@PathVariable String userId) {
        Summary summary = summaryService.getSummaryByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Summary not found for userId: " + userId));
        return ResponseEntity.ok(summary);
    }

    // ✅ PUT (Update existing summary by ID)
    @PutMapping("/{id}")
    public ResponseEntity<Summary> updateSummary(@PathVariable String id, @RequestBody Summary updatedSummary) {
        Summary summary = summaryService.updateSummary(id, updatedSummary)
                .orElseThrow(() -> new ResourceNotFoundException("Summary not found with id: " + id));
        return ResponseEntity.ok(summary);
    }

    // ✅ DELETE (Delete summary by ID)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSummary(@PathVariable String id) {
        summaryService.deleteSummary(id);
        return ResponseEntity.noContent().build();
    }
}
