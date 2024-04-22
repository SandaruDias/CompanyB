package com.example.CompanyB.SalesMarketingModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document (collection = "Inventory")
public class InventoryItem {

    @Id
    private String item_id;
    private String name;
    private int quantity_available;

    // Constructor, getters, and setters
}
