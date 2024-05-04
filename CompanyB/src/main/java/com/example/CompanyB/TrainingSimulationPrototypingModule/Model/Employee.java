package com.example.CompanyB.TrainingSimulationPrototypingModule.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Data
@Getter
@Setter
@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    private String employeeId;
    private String name;
    private String department;

    public void setSelectedCourse() {

    }

}