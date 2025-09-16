package com.villain.healthtracker.controller;

import com.villain.healthtracker.exception.ResourceNotFoundException;
import com.villain.healthtracker.model.Summary;
import com.villain.healthtracker.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:3000")
@RestController
@RequestMapping("/api/summary")
public class SummaryController {

    @Autowired
    private SummaryService summaryService;

    // ✅ Create summary
    @PostMapping
    public Summary createSummary(@RequestBody Summary summary) {
        return summaryService.saveSummary(summary);
    }

    // ✅ Get summary by summaryId
    @GetMapping("/{id}")
    public ResponseEntity<Summary> getSummaryById(@PathVariable String id) {
        Summary summary = summaryService.getSummaryById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Summary not found for id: " + id));
        return ResponseEntity.ok(summary);
    }

    // ✅ Get all summaries by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Summary>> getSummariesByUserId(@PathVariable String userId) {
        List<Summary> summaries = summaryService.getSummaryByUserId(userId);
        if (summaries.isEmpty()) {
            throw new ResourceNotFoundException("No summaries found for userId: " + userId);
        }
        return ResponseEntity.ok(summaries);
    }

    // ✅ Delete summary
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSummary(@PathVariable String id) {
        summaryService.deleteSummary(id);
        return ResponseEntity.noContent().build();
    }
}
