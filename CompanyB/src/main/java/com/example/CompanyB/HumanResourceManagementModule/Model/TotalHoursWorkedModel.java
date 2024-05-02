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

    // constructor
    public TotalHoursWorkedModel() {
        this.id = id;
        this.perMonthHoursWorked = perMonthHoursWorked;
    }

    // getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPerMonthHoursWorked() {
        return perMonthHoursWorked;
    }

    public void setPerMonthHoursWorked(double perMonthHoursWorked) {
        this.perMonthHoursWorked = perMonthHoursWorked;
    }
}
