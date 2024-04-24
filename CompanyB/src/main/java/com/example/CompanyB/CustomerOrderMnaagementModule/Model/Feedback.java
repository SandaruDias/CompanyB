package com.example.CompanyB.CustomerOrderMnaagementModule.Model;

public class Feedback {
    
    private String[] feedBack;
    private int ratings;
    private int orderId;
    
    public void setFeedBack(String[] feedBack) {
        this.feedBack = feedBack;
    }
    public void setRatings(int ratings) {
        this.ratings = ratings;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String[] getFeedBack() {
        return feedBack;
    }
    public int getRatings() {
        return ratings;
    }
    public int getOrderId() {
        return orderId;
    }

    

}
