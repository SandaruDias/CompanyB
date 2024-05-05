package com.example.CompanyB.SalesMarketingModule.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "SalesMarketing/SalesRecord")
public class SalesRecordModel {
    @Id
    private String productId;
    private int soldQuantity;
    private double billAmount;
    private double profit;

    // Constructors, getters, and setters
}
