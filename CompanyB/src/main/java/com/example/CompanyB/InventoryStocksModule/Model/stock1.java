package com.example.CompanyB.InventoryStocksModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "stock")
@Data
public class stock1 {
    @Id
    private String id;

    private String name;
    private Integer units;
    private String suppliername;
    private Integer baseValue;
    private String createdDateTime;
    private String updatedDateTime;
    private String updatedUser="stock manager";
}
