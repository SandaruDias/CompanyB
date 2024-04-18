package com.example.CompanyB.SalesMarketingModule.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "Orders")
public class OrderModel {

    @Id
    private String id;
    private String orderId;
    private String customerId;
    private Date orderDate;
    private List<OrderItem> items;
    private String status;

    // Getters and setters
}

