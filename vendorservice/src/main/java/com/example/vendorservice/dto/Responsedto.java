package com.example.vendorservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Responsedto {
    private Vendordto vendordto;
    private List<Trainingdto> trainingdto;

    public Responsedto(Vendordto vendordto, List<Trainingdto> trainingdto) {
        this.vendordto = vendordto;
        this.trainingdto = trainingdto;
    }

    public Responsedto() {
    }

    public Vendordto getVendordto() {
        return vendordto;
    }

    public void setVendordto(Vendordto vendordto) {
        this.vendordto = vendordto;
    }

    public List<Trainingdto> getTrainingdto() {
        return trainingdto;
    }

    public void setTrainingdto(List<Trainingdto> trainingdto) {
        this.trainingdto = trainingdto;
    }
}
