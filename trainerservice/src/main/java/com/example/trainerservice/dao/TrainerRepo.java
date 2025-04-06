package com.example.trainerservice.dao;

import com.example.trainerservice.dao.entity.TrainerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TrainerRepo extends JpaRepository<TrainerEntity,Long> {
    List<TrainerEntity> findByVendorId(Long vendorId);
    List<TrainerEntity> findByTrainingId(Long trainingId);
    List<TrainerEntity> findByStatus(TrainerEntity.TrainerStatus status);
    List<TrainerEntity> findByBudgetLessThanEqual(Double budget);
}
