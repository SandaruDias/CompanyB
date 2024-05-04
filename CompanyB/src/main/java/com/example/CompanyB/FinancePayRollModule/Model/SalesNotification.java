package com.example.CompanyB.FinancePayRollModule.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "salesNotifications")
public class SalesNotification {
    @Id
    private String id;
    private String orderId;  // Link to the Order connected with the Invoice
    private boolean processed;
    private Date createdAt;

    // Constructors, Getters, and Setters
    public SalesNotification() {
    }

    public SalesNotification(String id, String orderId, boolean processed, Date createdAt) {
        this.id = id;
        this.orderId = orderId;
        this.processed = processed;
        this.createdAt = createdAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
