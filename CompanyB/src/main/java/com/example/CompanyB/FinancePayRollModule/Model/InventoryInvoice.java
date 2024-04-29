package com.example.CompanyB.FinancePayRollModule.Model;

public class InventoryInvoice {
    private String materialName;
    private int quantityShort;
    private double marketPrice;
    private double potentialLoss;

    // Constructors, getters, and setters

    public InventoryInvoice(String materialName, int quantityShort, double marketPrice, double potentialLoss) {
        this.materialName = materialName;
        this.quantityShort = quantityShort;
        this.marketPrice = marketPrice;
        this.potentialLoss = potentialLoss;
    }

    public InventoryInvoice() {

    }

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
}
