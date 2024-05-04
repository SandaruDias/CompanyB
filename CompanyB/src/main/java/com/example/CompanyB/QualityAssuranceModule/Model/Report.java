package com.example.CompanyB.QualityAssuranceModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "reports")
public class Report {
    @Id
    private String id;

    private String prototypeId;

    private String reviewer;

    private String comments;

    private String reviewDate;

    // Getters and setters

}
