package com.example.trainingservice.service;

import com.example.trainingservice.dao.TrainingRepo;
import com.example.trainingservice.dao.entity.TrainingEntity;
import com.example.trainingservice.dto.Responsedto;
import com.example.trainingservice.dto.Trainerdto;
import com.example.trainingservice.dto.Trainingdto;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepo trainingRepo;

    @Autowired
    private WebClient webClient;

    // Add a new training
    public TrainingEntity addTraining(TrainingEntity training) {
        return trainingRepo.save(training);
    }

    // Get training by trainer ID
    public List<TrainingEntity> getTrainingsByTrainerId(Long trainerId) {
        return trainingRepo.findByTrainerId(trainerId);
    }

    // Get training by vendor ID
    public List<TrainingEntity> getTrainingsByVendorId(Long vendorId) {
        return trainingRepo.findByVendorId(vendorId);
    }

    // Get trainings by budget
    public List<TrainingEntity> getTrainingsByBudget(Double budget) {
        return trainingRepo.findByBudgetLessThanEqual(budget);
    }

    // Get trainings within a specific date range
    public List<TrainingEntity> getTrainingsByDateRange(Date startDate, Date endDate) {
        return trainingRepo.findByStartDateBetween(startDate, endDate);
    }

    // Get training by ID
    public Optional<TrainingEntity> getTrainingById(Long trainingId) {
        return trainingRepo.findById(trainingId);
    }

    // Get Training with Trainers (Similar to Flight with Passengers)
    @CircuitBreaker(name = "trainingService", fallbackMethod = "fallbackGetTrainingWithTrainers")
    public Responsedto getTrainingWithTrainers(Long trainingId) {
        Responsedto responseDto = new Responsedto();

        TrainingEntity training = trainingRepo.findById(trainingId)
                .orElseThrow(() -> new RuntimeException("Training not found"));
        Trainingdto trainingDto = mapToTrainingDto(training);

        List<Trainerdto> trainerList = webClient.get()
                .uri("http://localhost:9098/trainerinfo/" + training.getTrainingId()) // Adjust port as needed
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Trainerdto>>() {})
                .block();

        responseDto.setTrainingdto(trainingDto);
        responseDto.setTrainerdto(trainerList);

        return responseDto;
    }

    // Fallback method in case of failure
    public Responsedto fallbackGetTrainingWithTrainers(Long trainingId, Throwable throwable) {
        return new Responsedto(); // Return an empty response
    }

    // Helper method to map TrainingEntity to Trainingdto
    private Trainingdto mapToTrainingDto(TrainingEntity training) {
        Trainingdto dto = new Trainingdto();
        dto.setTrainingId(training.getTrainingId());
        dto.setVendorId(training.getVendorId());
        dto.setTrainerId(training.getTrainerId());
        dto.setBudget(training.getBudget());
        dto.setPoc(training.getPoc());
        dto.setStartDate(training.getStartDate());
        dto.setEndDate(training.getEndDate());
        return dto;
    }
}
