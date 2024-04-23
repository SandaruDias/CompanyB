package com.example.CompanyB.ManufacturingModule.Model;


public class OnGoingOrder {
    private String id;
    private int totalNumber;
    private  int onGoingStationOne;
    private int onGoingStationTwo;
    private  int onGoingStationThree;
    private int waitToOne;
    private int waitToTwo;
    private int waitToThree;
    private int completedNum;
    private  boolean isCompleted;
    private boolean QAResult;

    public OnGoingOrder(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public int getOnGoingStationOne() {
        return onGoingStationOne;
    }

    public int getOnGoingStationTwo() {
        return onGoingStationTwo;
    }

    public int getOnGoingStationThree() {
        return onGoingStationThree;
    }

    public int getWaitToOne() {
        return waitToOne;
    }

    public int getWaitToTwo() {
        return waitToTwo;
    }

    public int getWaitToThree() {
        return waitToThree;
    }

    public int getCompletedNum() {
        return completedNum;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public void setOnGoingStationOne(int onGoingStationOne) {
        this.onGoingStationOne = onGoingStationOne;
    }

    public void setOnGoingStationTwo(int onGoingStationTwo) {
        this.onGoingStationTwo = onGoingStationTwo;
    }

    public void setOnGoingStationThree(int onGoingStationThree) {
        this.onGoingStationThree = onGoingStationThree;
    }

    public void setWaitToOne(int waitToOne) {
        this.waitToOne = waitToOne;
    }

    public void setWaitToTwo(int waitToTwo) {
        this.waitToTwo = waitToTwo;
    }

    public void setWaitToThree(int waitToThree) {
        this.waitToThree = waitToThree;
    }

    public void setCompletedNum(int completedNum) {
        this.completedNum = completedNum;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public boolean isQAResult() {
        return QAResult;
    }

    public void setQAResult(boolean QAResult) {
        this.QAResult = QAResult;
    }
}
