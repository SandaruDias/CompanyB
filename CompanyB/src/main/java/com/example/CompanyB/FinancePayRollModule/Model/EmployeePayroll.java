//package com.example.CompanyB.FinancePayRollModule.Model;
//
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;
//import java.util.Date;
//
//@Document(collection = "payrolls")
//public class Payroll {
//    @Id
//    private String id;
//    private Long employeeId;
//    private String employeeName;  // Added to handle employee's name
//    private Date payPeriodStart;
//    private Date payPeriodEnd;
//    private Double HoursWorked;
//    private Double HourlyRate;
//    private Double OvertimeHours;
//    private Double OvertimeRate;
//    private Double grossSalary;
//    private Double netSalary;
//    private Double taxRate;       // To handle dynamic tax calculations
//    private Double taxDeductions;
//    private Double deductions;    // Other deductions like benefits, etc.
//    private Date payDate;
//    private String status;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
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
//    public Date getPayPeriodStart() {
//        return payPeriodStart;
//    }
//
//    public void setPayPeriodStart(Date payPeriodStart) {
//        this.payPeriodStart = payPeriodStart;
//    }
//
//    public Date getPayPeriodEnd() {
//        return payPeriodEnd;
//    }
//
//    public void setPayPeriodEnd(Date payPeriodEnd) {
//        this.payPeriodEnd = payPeriodEnd;
//    }
//
//    public Double getGrossSalary() {
//        return grossSalary;
//    }
//
//    public void setGrossSalary(Double grossSalary) {
//        this.grossSalary = grossSalary;
//    }
//
//    public Double getNetSalary() {
//        return netSalary;
//    }
//
//    public void setNetSalary(Double netSalary) {
//        this.netSalary = netSalary;
//    }
//
//    public Double getTaxRate() {
//        return taxRate;
//    }
//
//    public void setTaxRate(Double taxRate) {
//        this.taxRate = taxRate;
//    }
//
//    public Double getTaxDeductions() {
//        return taxDeductions;
//    }
//
//    public void setTaxDeductions(Double taxDeductions) {
//        this.taxDeductions = taxDeductions;
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
//    public Date getPayDate() {
//        return payDate;
//    }
//
//    public void setPayDate(Date payDate) {
//        this.payDate = payDate;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public Double getHoursWorked() {
//        return HoursWorked;
//    }
//
//    public void setHoursWorked(Double hoursWorked) {
//        HoursWorked = hoursWorked;
//    }
//
//    public Double getHourlyRate() {
//        return HourlyRate;
//    }
//
//    public void setHourlyRate(Double hourlyRate) {
//        HourlyRate = hourlyRate;
//    }
//
//    public Double getOvertimeHours() {
//        return OvertimeHours;
//    }
//
//    public void setOvertimeHours(Double overtimeHours) {
//        OvertimeHours = overtimeHours;
//    }
//
//    public Double getOvertimeRate() {
//        return OvertimeRate;
//    }
//
//    public void setOvertimeRate(Double overtimeRate) {
//        OvertimeRate = overtimeRate;
//    }
//}

package com.example.CompanyB.FinancePayRollModule.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document
public class EmployeePayroll {
    @Id
    private String payrollId;
    private String employeeId;
    private String employeeName;
    private double basicSalary;
    private double otHours;
    private double workingDays;
    private double allowance;
    private double taxPercentage;
    private double deductions;
    private Date payrollDate;

    private Date payrollStartDate;

    private Date payrollEndDate;

    private double grossPay;
    private double netPay;

    // Constructors, getters, and setters

    public String getPayrollId() {
        return payrollId;
    }

    public void setPayrollId(String payrollId) {
        this.payrollId = payrollId;
    }

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

    public double getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(double workingDays) {
        this.workingDays = workingDays;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
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

    public Date getPayrollDate() {
        return payrollDate;
    }

    public void setPayrollDate(Date payrollDate) {
        this.payrollDate = payrollDate;
    }

    public Date getPayrollStartDate() {
        return payrollStartDate;
    }

    public void setPayrollStartDate(Date payrollStartDate) {
        this.payrollStartDate = payrollStartDate;
    }

    public Date getPayrollEndDate() {
        return payrollEndDate;
    }

    public void setPayrollEndDate(Date payrollEndDate) {
        this.payrollEndDate = payrollEndDate;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }


}
