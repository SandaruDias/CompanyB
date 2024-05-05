package com.example.CompanyB.TrainingSimulationPrototypingModule.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "courses")
public class Course {
    @Id
    private String id;
    private String courseName;
    private int skillLevel;

    // Constructors, getters, and setters
}
