package com.example.trainerservice.controller;

import com.example.trainerservice.dao.entity.TrainerEntity;
import com.example.trainerservice.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainers")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    // Add a new trainer
    @PostMapping("/add")
    public TrainerEntity addTrainer(@RequestBody TrainerEntity trainer) {
        return trainerService.addTrainer(trainer);
    }

    // Get trainers by vendorId
    @GetMapping("/vendorId/{vendorId}")
    public List<TrainerEntity> getTrainersByVendorId(@PathVariable Long vendorId) {
        return trainerService.getTrainersByVendorId(vendorId);
    }

    // Get trainers by trainingId
    @GetMapping("/trainingId/{trainingId}")
    public List<TrainerEntity> getTrainersByTrainingId(@PathVariable Long trainingId) {
        return trainerService.getTrainersByTrainingId(trainingId);
    }

    // Get trainers by status
    @GetMapping("/status/{status}")
    public List<TrainerEntity> getTrainersByStatus(@PathVariable TrainerEntity.TrainerStatus status) {
        return trainerService.getTrainersByStatus(status);
    }

    // Get trainers by budget
    @GetMapping("/budget/{budget}")
    public List<TrainerEntity> getTrainersByBudget(@PathVariable Double budget) {
        return trainerService.getTrainersByBudget(budget);
    }
}
