//package com.example.CompanyB.FinancePayRollModule.Service.dto;
//public class PayrollDTO {
//    private Long employeeId;
//    private String employeeName;
//    private Double hoursWorked;
//    private Double hourlyRate;
//    private Double overtimeHours;
//    private Double overtimeRate;
//    private Double deductions;
//    private Double taxRate;
//
//    // Getters and Setters
//    public Long getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(Long employeeId) {
//        this.employeeId = employeeId;
//    }
//
//    public String getEmployeeName() {
//        return employeeName;
//    }
//
//    public void setEmployeeName(String employeeName) {
//        this.employeeName = employeeName;
//    }
//
//    public Double getHoursWorked() {
//        return hoursWorked;
//    }
//
//    public void setHoursWorked(Double hoursWorked) {
//        this.hoursWorked = hoursWorked;
//    }
//
//    public Double getHourlyRate() {
//        return hourlyRate;
//    }
//
//    public void setHourlyRate(Double hourlyRate) {
//        this.hourlyRate = hourlyRate;
//    }
//
//    public Double getOvertimeHours() {
//        return overtimeHours;
//    }
//
//    public void setOvertimeHours(Double overtimeHours) {
//        this.overtimeHours = overtimeHours;
//    }
//
//    public Double getOvertimeRate() {
//        return overtimeRate;
//    }
//
//    public void setOvertimeRate(Double overtimeRate) {
//        this.overtimeRate = overtimeRate;
//    }
//
//    public Double getDeductions() {
//        return deductions;
//    }
//
//    public void setDeductions(Double deductions) {
//        this.deductions = deductions;
//    }
//
//    public Double getTaxRate() {
//        return taxRate;
//    }
//
//    public void setTaxRate(Double taxRate) {
//        this.taxRate = taxRate;
//    }
//}


package com.example.CompanyB.FinancePayRollModule.Service.dto;

import java.util.Date;

public class PayrollDTO {
    private String id;
    private String employeeId;
    private String employeeName;
    private double basicSalary;
    private double otHours;
    private double salaryPerHour;
    private double workingHours;
    private double taxPercentage;
    private double deductions;
    private double benefits;
    private Date payrollDate;

    // Getters and setters

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    public double getOtHours() {
        return otHours;
    }

    public void setOtHours(double otHours) {
        this.otHours = otHours;
    }

    public double getSalaryPerHour() {
        return salaryPerHour;
    }

    public void setSalaryPerHour(double salaryPerHour) {
        this.salaryPerHour = salaryPerHour;
    }

    public double getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(double workingHours) {
        this.workingHours = workingHours;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getBenefits() {
        return benefits;
    }

    public void setBenefits(double benefits) {
        this.benefits = benefits;
    }

    public Date getPayrollDate() {
        return payrollDate;
    }

    public void setPayrollDate(Date payrollDate) {
        this.payrollDate = payrollDate;
    }
}
