package com.villain.healthtracker.service;

import com.villain.healthtracker.model.Summary;
import com.villain.healthtracker.repository.SummaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SummaryService {

    @Autowired
    private SummaryRepository summaryRepo;

    // ✅ Save summary
    public Summary saveSummary(Summary summary) {
        return summaryRepo.save(summary);
    }

    // ✅ Get all summaries by userId (String)
    public List<Summary> getSummaryByUserId(String userId) {
        return summaryRepo.findByUserId(userId);
    }

    // ✅ Get one summary by id (String)
    public Optional<Summary> getSummaryById(String id) {
        return summaryRepo.findById(id);
    }

    // ✅ Delete summary by id (String)
    public void deleteSummary(String id) {
        summaryRepo.deleteById(id);
    }
}
