package com.example.CompanyB.InventoryStocksModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(value = "product")
public class Product {

    @Id
    private String id;

    private String name;
    private String description;
    private int units;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

}

