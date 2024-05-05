package com.example.CompanyB.TrainingSimulationPrototypingModule.DTO;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
public class SimTestTO {
    @Id
    private String testID;
    private boolean simulApproval;
    @Field("comments")
    private String simulComments;
    private byte[] designDoc;
    private boolean circuitSimulStatus;
    private boolean thermalSimulStatus;
    private boolean manufacturabilityStatus;

}
