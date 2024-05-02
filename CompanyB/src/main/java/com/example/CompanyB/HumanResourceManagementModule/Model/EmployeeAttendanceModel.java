package com.example.CompanyB.HumanResourceManagementModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "employeeAttendancedb")
@Data
public class EmployeeAttendanceModel {

    @Id
    private String id ;

    private double hoursWorked;
    private LocalDateTime checkInTime;
    private LocalDateTime checkOutTime;
    private double perMonthHoursWorked;

    // Default constructor
    public EmployeeAttendanceModel() {
        // Default constructor with no arguments
    }

    public EmployeeAttendanceModel(String id, double hoursWorked, LocalDateTime checkInTime, LocalDateTime checkOutTime, double perMonthHoursWorked) {
        this.id = id;
        this.hoursWorked = hoursWorked;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.perMonthHoursWorked = perMonthHoursWorked;

    }

    // setter methods
    public void setId(String id) {
        this.id = id;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public void setCheckInTime(LocalDateTime checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setCheckOutTime(LocalDateTime checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void setPerMonthHoursWorked(double perMonthHoursWorked) {
        this.perMonthHoursWorked = perMonthHoursWorked;
    }


    // getter methods

    public String getId() {
        return id;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public LocalDateTime getCheckInTime() {
        return checkInTime;
    }

    public LocalDateTime getCheckOutTime() {
        return checkOutTime;
    }

    public double getPerMonthHoursWorked() {
        return perMonthHoursWorked;
    }

}
