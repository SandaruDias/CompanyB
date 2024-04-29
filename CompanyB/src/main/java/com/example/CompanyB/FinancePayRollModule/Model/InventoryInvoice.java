package com.example.CompanyB.FinancePayRollModule.Model;

import java.util.Date;

public class InventoryInvoice {
    private String materialName;
    private int quantityShort;
    private double marketPrice;
    private double potentialLoss;
    private String adjustmentPlan;
    private String urgentOrderDetails;

    private Date dueDate;

    public InventoryInvoice(String materialName, int quantityShort, double marketPrice, double potentialLoss, String adjustmentPlan, String urgentOrderDetails, Date dueDate) {
        this.materialName = materialName;
        this.quantityShort = quantityShort;
        this.marketPrice = marketPrice;
        this.potentialLoss = potentialLoss;
        this.adjustmentPlan = adjustmentPlan;
        this.urgentOrderDetails = urgentOrderDetails;
        this.dueDate = dueDate;
    }

    public InventoryInvoice() {}

    // Getters and Setters for all fields

    public String getMaterialName() {
        return materialName;
    }

    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    public int getQuantityShort() {
        return quantityShort;
    }

    public void setQuantityShort(int quantityShort) {
        this.quantityShort = quantityShort;
    }

    public double getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(double marketPrice) {
        this.marketPrice = marketPrice;
    }

    public double getPotentialLoss() {
        return potentialLoss;
    }

    public void setPotentialLoss(double potentialLoss) {
        this.potentialLoss = potentialLoss;
    }

    public String getAdjustmentPlan() {
        return adjustmentPlan;
    }

    public void setAdjustmentPlan(String adjustmentPlan) {
        this.adjustmentPlan = adjustmentPlan;
    }

    public String getUrgentOrderDetails() {
        return urgentOrderDetails;
    }

    public void setUrgentOrderDetails(String urgentOrderDetails) {
        this.urgentOrderDetails = urgentOrderDetails;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
