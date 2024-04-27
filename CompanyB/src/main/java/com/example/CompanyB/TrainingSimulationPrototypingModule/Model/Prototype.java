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
    private Long id;

    @Setter
    private String materials;
    @Setter
    private String comments;
    @Getter
    private String shape;
    @Getter
    private String color;
    @Setter
    private boolean isRejected;
    @Setter
    @Getter
    private String rejectionMessage;
    private String designDocument;
    private String prototypeShape;
    private String selectedMaterials;
    private String designComments;
    private String practicalExperiment;
    private Boolean userPreferences;
    private Boolean finalApproval;
    private Boolean statusSimulationApproval;


}
    