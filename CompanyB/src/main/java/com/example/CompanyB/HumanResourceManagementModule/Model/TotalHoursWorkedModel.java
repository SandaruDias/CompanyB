package com.example.CompanyB.HumanResourceManagementModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "totalHoursdb")
@Data
public class TotalHoursWorkedModel {

    @Id
    private String id ;
    private double perMonthHoursWorked;
}
