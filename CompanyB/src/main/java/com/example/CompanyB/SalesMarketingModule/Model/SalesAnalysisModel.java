package com.example.CompanyB.SalesMarketingModule.Model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "SalesMarketing/Analysis")
public class SalesAnalysisModel {

    private String id;
    private Date saleDate;
    private double amount;
    private double profit;

    private String productId;
    private String productName;
    private int quantity;

}
