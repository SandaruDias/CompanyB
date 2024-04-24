package com.example.CompanyB.CustomerOrderMnaagementModule.Model;

public class OrderModel {

    private int orderId;
    private int customer; 
    private String[] orderInfo;
    private boolean simulationStatus;
    private boolean partsAvailable ;
    private boolean confirmation;
    private boolean manufactureDone;
    private double payment;

    
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public void setCustomer(int customer) {
        this.customer = customer;
    }
    public void setOrderInfo(String[] orderInfo) {
        this.orderInfo = orderInfo;
    }
    public void setSimulationStatus(boolean simulationStatus) {
        this.simulationStatus = simulationStatus;
    }
    public void setPartsAvailable(boolean partsAvailable) {
        this.partsAvailable = partsAvailable;
    }
    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }
    public void setManufactureDone(boolean manufactureDone) {
        this.manufactureDone = manufactureDone;
    }
    public void setPayment(double payment) {
        this.payment = payment;
    }

    public int getOrderId() {
        return orderId;
    }
    public int getCustomer() {
        return customer;
    }
    public String[] getOrderInfo() {
        return orderInfo;
    }
    public boolean isSimulationStatus() {
        return simulationStatus;
    }
    public boolean isPartsAvailable() {
        return partsAvailable;
    }
    public boolean isConfirmation() {
        return confirmation;
    }
    public boolean isManufactureDone() {
        return manufactureDone;
    }
    public double getPayment() {
        return payment;
    }    

}
