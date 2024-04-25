package com.example.CompanyB.ManufacturingModule.DataTransferObject;

import java.util.Date;

public class User {
    private String id;
    private Date releasedDate;
    private String orderComponents;
    private int numberOfItems;
    private boolean isReleased;

    public User(String id, Date releasedDate, String orderComponents, int numberOfItems, boolean isReleased) {
        this.id = id;
        this.releasedDate = releasedDate;
        this.orderComponents = orderComponents;
        this.numberOfItems = numberOfItems;
        this.isReleased = isReleased;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getReleasedDate() {
        return releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    public String getOrderComponents() {
        return orderComponents;
    }

    public void setOrderComponents(String orderComponents) {
        this.orderComponents = orderComponents;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public boolean isReleased() {
        return isReleased;
    }

    public void setReleased(boolean released) {
        isReleased = released;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", releasedDate=" + releasedDate +
                ", orderComponents='" + orderComponents + '\'' +
                ", numberOfItems=" + numberOfItems +
                ", isReleased=" + isReleased +
                '}';
    }
}
