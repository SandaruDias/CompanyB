package com.example.CompanyB.HumanResourceManagementModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Employ extends Person{
    @Id
    private Integer id ;
    private String recruitedDate;
    private String position;
    private int salary;
    private int otRate;
    private String division;
}
