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
    private String password;
    private double allowance;
    private String division;
    private int otRate;
    private double workingHours;

    public double getAllowance() {
        return allowance;
    }

    public Integer getId() {
        return id;
    }

    public String getRecruitedDate() {
        return recruitedDate;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public int getOtRate() {
        return otRate;
    }

    public String getDivision() {
        return division;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
