package com.example.trainerservice.service;

import com.example.trainerservice.dao.TrainerRepo;
import com.example.trainerservice.dao.entity.TrainerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepo trainerRepo;

    public TrainerEntity addTrainer(TrainerEntity trainer) {
        return trainerRepo.save(trainer);
    }

    public List<TrainerEntity> getTrainersByVendorId(Long vendorId) {
        return trainerRepo.findByVendorId(vendorId);
    }

    public List<TrainerEntity> getTrainersByTrainingId(Long trainingId) {
        return trainerRepo.findByTrainingId(trainingId);
    }

    public List<TrainerEntity> getTrainersByStatus(TrainerEntity.TrainerStatus status) {
        return trainerRepo.findByStatus(status);
    }

    public List<TrainerEntity> getTrainersByBudget(Double budget) {
        return trainerRepo.findByBudgetLessThanEqual(budget);
    }
}
