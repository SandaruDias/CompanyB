package com.example.CompanyB.FinancePayRollModule.Service.dto;

public class CustomerDTO {
    private String id;
    private String name;
    private Double creditScore;

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    public Double getCreditScore() {
        return creditScore;
    }

    void setCreditScore(Double creditScore) {
        this.creditScore = creditScore;
    }
}
