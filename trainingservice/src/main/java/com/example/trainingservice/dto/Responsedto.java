package com.example.trainingservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor

public class Responsedto {
    private Trainingdto trainingdto;
    private List<Trainerdto> trainerdto;

    public Responsedto(Trainingdto trainingdto, List<Trainerdto> trainerdto) {
        this.trainingdto = trainingdto;
        this.trainerdto = trainerdto;
    }

    public Responsedto() {
    }

    public Trainingdto getTrainingdto() {
        return trainingdto;
    }

    public void setTrainingdto(Trainingdto trainingdto) {
        this.trainingdto = trainingdto;
    }

    public List<Trainerdto> getTrainerdto() {
        return trainerdto;
    }

    public void setTrainerdto(List<Trainerdto> trainerdto) {
        this.trainerdto = trainerdto;
    }
}
