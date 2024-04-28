package com.example.CompanyB.SalesMarketingModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Data
@Document(collection = "SalesMarketing/Sales")
public class SalesReportModel {

    private String id;
    private Date saleDate;
    private double amount;
    private double profit;

    // Getters and setters
}
