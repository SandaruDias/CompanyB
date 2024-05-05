package com.example.CompanyB.SalesMarketingModule.Model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
<<<<<<< HEAD:CompanyB/src/main/java/com/example/CompanyB/SalesMarketingModule/Model/SalesOrderModel.java
@Document(collection = "Orders")
public class SalesOrderModel {
=======
@Document(collection = "SalesMarketing/Orders")
public class OrderModel {
>>>>>>> SalesMarketingSystem:CompanyB/src/main/java/com/example/CompanyB/SalesMarketingModule/Model/OrderModel.java

    @Id
    private ObjectId _id;
   // private String order_id;
    private String customer_id;
    private String order_date;
    private List<OrderItem> items;
    private String status;

    // Getters and setters
}

