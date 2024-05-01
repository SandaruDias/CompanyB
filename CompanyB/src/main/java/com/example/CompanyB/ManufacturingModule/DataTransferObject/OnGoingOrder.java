package com.example.CompanyB.ManufacturingModule.DataTransferObject;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Manufacturing_Order")
public class  OnGoingOrder {
    @Id
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
    private int errorOne;
    private int errorTwo;
    private int errorThree;

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

    public int getErrorOne() {
        return errorOne;
    }

    public void setErrorOne(int errorOne) {
        this.errorOne = errorOne;
    }

    public int getErrorTwo() {
        return errorTwo;
    }

    public void setErrorTwo(int errorTwo) {
        this.errorTwo = errorTwo;
    }

    public int getErrorThree() {
        return errorThree;
    }

    public void setErrorThree(int errorThree) {
        this.errorThree = errorThree;
    }

    @Override
    public String toString() {
        return "OnGoingOrder{" +
                "id='" + id + '\'' +
                ", totalNumber=" + totalNumber +
                ", onGoingStationOne=" + onGoingStationOne +
                ", onGoingStationTwo=" + onGoingStationTwo +
                ", onGoingStationThree=" + onGoingStationThree +
                ", waitToOne=" + waitToOne +
                ", waitToTwo=" + waitToTwo +
                ", waitToThree=" + waitToThree +
                ", completedNum=" + completedNum +
                ", isCompleted=" + isCompleted +
                ", QAResult=" + QAResult +
                ", errorOne=" + errorOne +
                ", errorTwo=" + errorTwo +
                ", errorThree=" + errorThree +
                '}';
    }
}
