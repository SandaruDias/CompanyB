package com.example.CompanyB.TrainingSimulationPrototypingModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "employees")
public class TPSEmployee {
    @Id
    private String _Id;
    private String firstName;
    private String courseLevel;
    private String selectedCourseId;  // Updated to store the selected course ID

    // Getters and setters
}
