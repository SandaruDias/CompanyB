package com.example.CompanyB.TrainingSimulationPrototypingModule.Model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.awt.*;

@Document(collection = "Simulations")
@Data
@Builder
public class SimTest
{
    @Id
    private String testID;
    @Field("Design File")
    private byte[] designDoc;
    @Field("simulation_approval")
    private boolean simulApproval;
    @Field("comments")
    private String simulComments;
    @Field("Circuit Simulation Status")
    private boolean circuitSimulStatus;
    @Field("Thermal Simulation Status")
    private boolean thermalSimulStatus;
    @Field("Manufacturability")
    private boolean manufacturabilityStatus;

    public SimTest() {
        // Default constructor
    }

    public SimTest(String testID, boolean simulApproval, String simulComments,
                   boolean circuitSimulStatus, boolean thermalSimulStatus, boolean manufacturabilityStatus) {
        this.testID = testID;
        this.simulApproval = simulApproval;
        this.simulComments = simulComments;
        this.circuitSimulStatus = circuitSimulStatus;
        this.thermalSimulStatus = thermalSimulStatus;
        this.manufacturabilityStatus = manufacturabilityStatus;
    }
}
