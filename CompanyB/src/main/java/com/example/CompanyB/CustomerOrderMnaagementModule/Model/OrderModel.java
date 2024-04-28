package com.example.CompanyB.CustomerOrderMnaagementModule.Model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {

    @Id
    private ObjectId id;
    private String customerID; 
    private Object orderInfo;
    private String pcbFile;
    private boolean simulationStatus;
    private boolean partsAvailable ;
    private boolean confirmation;
    private String manufactureDone;
    private double payment;

    @DocumentReference
    private Feedback feedback; 

    
    
}
