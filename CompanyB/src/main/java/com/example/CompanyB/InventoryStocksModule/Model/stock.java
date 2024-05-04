package com.example.CompanyB.InventoryStocksModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Document(collection = "Raw_materials")
@Data
public class stock {
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
