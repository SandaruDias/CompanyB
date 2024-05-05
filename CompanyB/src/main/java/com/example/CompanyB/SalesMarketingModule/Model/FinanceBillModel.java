package com.example.CompanyB.SalesMarketingModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "SalesMarketing/FinanceBill")
public class FinanceBillModel {

    private String id;
    private String userId;
    private String billOfMaterial;
    private double totalSale;
    private double totalProfit;

    // Constructors, getters, setters, and other methods
}
