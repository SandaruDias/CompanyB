package com.example.CompanyB.FinancePayRollModule.Service.dto;

public class InvoiceUpdateDTO {
    private Double amount;
    private Boolean status;

    // Getters and setters
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
