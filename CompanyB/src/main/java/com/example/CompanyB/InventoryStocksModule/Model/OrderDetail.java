package com.example.CompanyB.InventoryStocksModule.Model;

import com.example.CompanyB.InventoryStocksModule.Model.stock;
import com.example.CompanyB.InventoryStocksModule.Model.supplier;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Order_Rawmat")
@Data
public class OrderDetail {
    @Id
    private String id; 
    public String productId;
    private Integer units;
    
    @DBRef
    public stock product;

    @DBRef
    public supplier supplier;
}

