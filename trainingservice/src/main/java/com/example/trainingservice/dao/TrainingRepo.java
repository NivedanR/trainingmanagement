package com.example.trainingservice.dao;

import com.example.trainingservice.dao.entity.TrainingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Date;
import java.util.List;

public interface TrainingRepo extends JpaRepository<TrainingEntity, Long> {

    // Find all trainings assigned to a specific trainer
    List<TrainingEntity> findByTrainerId(Long trainerId);

    // Find all trainings assigned to a specific vendor
    List<TrainingEntity> findByVendorId(Long vendorId);

    // Find trainings within a budget range
    List<TrainingEntity> findByBudgetLessThanEqual(Double budget);

    // Find trainings happening in a specific date range
    List<TrainingEntity> findByStartDateBetween(Date start, Date end);


}
