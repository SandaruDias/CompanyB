
package com.example.CompanyB.TrainingSimulationPrototypingModule.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Prototype")
@Getter
@Setter
public class TSPPrototypeModel {
    @Id
    private String id;
    private byte[] designDocumentPdf;
    private String material;
    private String color;
    private String shape;
    private String comments;
    private boolean thermalTestPassed;
    private boolean electricalTestPassed;
    private boolean approvalStatus;
    private String approvalMessage;
}




