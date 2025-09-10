package com.villain.healthtracker.controller;

import com.villain.healthtracker.dto.SummaryResponse;
import com.villain.healthtracker.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/summary")
public class SummaryController {

    @Autowired
    private SummaryService summaryService;

    @GetMapping("/{userId}")
    public SummaryResponse getSummary(@PathVariable String userId) {
        return summaryService.getUserSummary(userId);
    }
}
