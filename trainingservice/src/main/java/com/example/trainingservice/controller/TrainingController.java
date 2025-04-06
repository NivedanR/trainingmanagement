package com.example.trainingservice.controller;

import com.example.trainingservice.dao.entity.TrainingEntity;
import com.example.trainingservice.service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    // Add a new training
    @PostMapping("/add")
    public TrainingEntity addTraining(@RequestBody TrainingEntity training) {
        return trainingService.addTraining(training);
    }

    // Get training by trainer ID
    @GetMapping("/trainerId/{trainerId}")
    public List<TrainingEntity> getTrainingsByTrainerId(@PathVariable Long trainerId) {
        return trainingService.getTrainingsByTrainerId(trainerId);
    }

    // Get training by vendor ID
    @GetMapping("/vendorId/{vendorId}")
    public List<TrainingEntity> getTrainingsByVendorId(@PathVariable Long vendorId) {
        return trainingService.getTrainingsByVendorId(vendorId);
    }

    // Get trainings by budget
    @GetMapping("/budget/{budget}")
    public List<TrainingEntity> getTrainingsByBudget(@PathVariable Double budget) {
        return trainingService.getTrainingsByBudget(budget);
    }

    // Get trainings by date range
    @GetMapping("/date-range")
    public List<TrainingEntity> getTrainingsByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        return trainingService.getTrainingsByDateRange(startDate, endDate);
    }

    // Get training by ID
    @GetMapping("/{trainingId}")
    public Optional<TrainingEntity> getTrainingById(@PathVariable Long trainingId) {
        return trainingService.getTrainingById(trainingId);
    }
}
