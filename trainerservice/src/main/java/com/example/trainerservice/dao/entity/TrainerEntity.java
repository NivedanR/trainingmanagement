package com.example.trainerservice.dao.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
public class TrainerEntity {

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

}
