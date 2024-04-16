package com.example.CompanyB.HumanResourceManagementModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
@Data
public class Applicant extends Person{
    @Id
    private UUID id =UUID.randomUUID();
    private String education;
    private int serviceYear;
    private String position;
    private int zipCode;
    private String about;
}
