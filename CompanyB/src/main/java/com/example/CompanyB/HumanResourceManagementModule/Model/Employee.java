package com.example.CompanyB.HumanResourceManagementModule.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Employee")
@Getter
@Setter
public class Employee extends Person{
    @Id
    private String userId ;
    private String recruitedDate;
    private int salary;
    private double allowance;
    private int otRate;
    private double workingDays;
    private Integer courseLevel;
}
