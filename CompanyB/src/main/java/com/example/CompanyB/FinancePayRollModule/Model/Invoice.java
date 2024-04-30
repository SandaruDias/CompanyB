package com.example.CompanyB.FinancePayRollModule.Model;

import com.example.CompanyB.FinancePayRollModule.Service.dto.ProductDetailsDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Document(collection = "invoices")
public class Invoice {
    @Id
    private String id;
    private String customerId;  // Reference to Customer ID from Sales System
    private Double amount;      // Total amount of the invoice
    private Date dueDate;
    private Boolean status;     // Paid or unpaid status
    private List<ProductDetailsDTO> products; // Product details from the order

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<ProductDetailsDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDetailsDTO> products) {
        this.products = products;
    }
}



