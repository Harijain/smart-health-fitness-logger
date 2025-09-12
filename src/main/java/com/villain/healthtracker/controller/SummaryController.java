package com.villain.healthtracker.controller;

import com.villain.healthtracker.model.Summary;
import com.villain.healthtracker.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/summary")
public class SummaryController {

    @Autowired
    private SummaryService summaryService;

    // GET Summary by userId
    @GetMapping("/{userId}")
    public Summary getSummary(@PathVariable String userId) {
        return summaryService.getUserSummary(userId);
    }

    // POST Summary (agar manually data bhejna ho to)
    @PostMapping
    public Summary createSummary(@RequestBody Summary summary) {
        return summary;
    }
}
