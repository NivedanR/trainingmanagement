package com.example.trainingservice.dto;

import jakarta.persistence.ElementCollection;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainerdto {

    @Id
    public Long trainerId;

    public String name;
    public String email;
    public Long vendorId;
    public Long trainingId;
    public Double budget;

    @ElementCollection
    public List<String> skills;

    public String contactNo;

//    @Enumerated(EnumType.STRING)
//    public TrainerStatus status;
//}

    public enum TrainerStatus {
        AVAILABLE,
        OCCUPIED
    }

    public Trainerdto(Long trainerId, String name, String email, Long vendorId, Long trainingId, Double budget, List<String> skills, String contactNo) {
        this.trainerId = trainerId;
        this.name = name;
        this.email = email;
        this.vendorId = vendorId;
        this.trainingId = trainingId;
        this.budget = budget;
        this.skills = skills;
        this.contactNo = contactNo;
    }

    public Trainerdto() {
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public Long getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(Long trainingId) {
        this.trainingId = trainingId;
    }

    public Long getVendorId() {
        return vendorId;
    }

    public void setVendorId(Long vendorId) {
        this.vendorId = vendorId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }
}

