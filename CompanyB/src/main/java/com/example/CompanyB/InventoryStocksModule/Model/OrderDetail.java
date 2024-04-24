package com.example.CompanyB.InventoryStocksModule.Model;

import com.example.CompanyB.InventoryStocksModule.Model.stock1;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "OrderDetail")
@Data
public class OrderDetail {
    @Id
    private String id; 

    public String productId;
    
    @DBRef
    public stock1 product;
    private Integer units;
    private String suppliername;
}

