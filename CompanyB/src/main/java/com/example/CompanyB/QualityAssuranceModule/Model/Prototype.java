package com.example.CompanyB.QualityAssuranceModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;

@Data
@Document(collection = "prototypes")
public class Prototype {
    @Id
    private String id;

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    // Getters and setters

}
