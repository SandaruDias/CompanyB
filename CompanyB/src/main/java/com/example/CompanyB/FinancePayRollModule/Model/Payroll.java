package com.example.CompanyB.FinancePayRollModule.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "payrolls")
public class Payroll {
    @Id
    private String id;

    private Long employeeId;
    private Date payPeriodStart;
    private Date payPeriodEnd;
    private Double grossSalary;
    private Double netSalary;
    private Double taxDeductions;
    private Date payDate;
    private String status;

    public String getId() {
        return id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public Date getPayPeriodStart() {
        return payPeriodStart;
    }

    public Date getPayPeriodEnd() {
        return payPeriodEnd;
    }

    public Double getGrossSalary() {
        return grossSalary;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public Double getTaxDeductions() {
        return taxDeductions;
    }

    public Date getPayDate() {
        return payDate;
    }

    public String getStatus() {
        return status;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public void setPayPeriodStart(Date payPeriodStart) {
        this.payPeriodStart = payPeriodStart;
    }

    public void setPayPeriodEnd(Date payPeriodEnd) {
        this.payPeriodEnd = payPeriodEnd;
    }

    public void setGrossSalary(Double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }

    public void setTaxDeductions(Double taxDeductions) {
        this.taxDeductions = taxDeductions;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}