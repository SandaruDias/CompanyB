package com.example.CompanyB.InventoryStocksModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Supplier_info")
@Data
public class supplier {
    @Id
    private String id;

    private String suppliername;
    private String telephone;
    private String address;
    private String email;
    
}
