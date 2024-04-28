package com.example.CompanyB.ManufacturingModule.DataTransferObject;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Document(collection = "Manufacturing_Workstation")
public class FetchWorksStationUser {

    @Id
    private String id;

    private Integer workStationId;
    private String userId;
    private String userName;
    private boolean isActive;
    private List<String> orderID;

//    private List<StationOrder> oderId;
//    private Map<String,Integer> HashMap;


    public FetchWorksStationUser( Integer workStationId, String userId, String userName, boolean isActive) {
        this.workStationId = workStationId;
        this.userId = userId;
        this.userName = userName;
        this.isActive = isActive;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getWorkStationId() {
        return workStationId;
    }

    public void setWorkStationId(Integer workStationId) {
        this.workStationId = workStationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }



//    public List<StationOrder> getOderId() {
//        return oderId;
//    }
//
//    public void setOderId(List<StationOrder> oderId) {
//        this.oderId = oderId;
//    }


    @Override
    public String toString() {
        return "FetchWorksStationUser{" +
                "id='" + id + '\'' +
                ", workStationId=" + workStationId +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", isActive=" + isActive +
                ", orderID=" + orderID +
                '}';
    }
}
