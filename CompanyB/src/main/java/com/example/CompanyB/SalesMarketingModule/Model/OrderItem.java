package com.example.CompanyB.SalesMarketingModule.Model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "SalesMarketing/Orders")
public class OrderItem {

    private String item_id;
    private int quantity;
    private String stock_status;

}
