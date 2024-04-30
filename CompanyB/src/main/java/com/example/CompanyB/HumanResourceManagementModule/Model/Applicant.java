package com.example.CompanyB.HumanResourceManagementModule.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Applicant")
@Getter
@Setter
public class Applicant extends Person {
    @Id
    private String Nic;
    private String education;
    private String about;
}
