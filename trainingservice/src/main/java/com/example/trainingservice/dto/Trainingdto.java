package com.example.trainingservice.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainingdto {

    @Id
    public Long trainingId;
    public Long vendorId;
    public Long trainerId;
    public Double budget;
    public String poc;
    public Date startDate;
    public Date endDate;

    public Trainingdto(Long trainingId, Long vendorId, Long trainerId, Double budget, String poc, Date startDate, Date endDate) {
        this.trainingId = trainingId;
        this.vendorId = vendorId;
        this.trainerId = trainerId;
        this.budget = budget;
        this.poc = poc;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Trainingdto() {
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

    public Long getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(Long trainerId) {
        this.trainerId = trainerId;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }

    public String getPoc() {
        return poc;
    }

    public void setPoc(String poc) {
        this.poc = poc;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
