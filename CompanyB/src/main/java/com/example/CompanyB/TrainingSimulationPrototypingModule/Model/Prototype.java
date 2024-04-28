package com.example.CompanyB.TrainingSimulationPrototypingModule.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Prototype")
public class Prototype {

    @Id
    private Long id; // Unique identifier for the prototype

    private String materials; // Materials used in the prototype

    private String comments; // Notes or feedback about the prototype

    private String shape; // Shape of the prototype

    private String color; // Color of the prototype

    private boolean isRejected; // Flag indicating if the design is rejected

    private String rejectionMessage; // Reason for rejection (if applicable)


}

    