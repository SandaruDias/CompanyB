package com.example.CompanyB.CustomerOrderMnaagementModule.Model;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Document(collection = "Order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderModel {

    @Id
    private ObjectId id;
    private String customerID;
    
    private int layers;
    private int quantity;
    private double thickness;
    private List<Double> dimensions;

    private byte[] pcbFile;
    
    private boolean simulationStatus;
    private boolean partsAvailable;

    private String deliveryAddress;
    private double payment;
    private boolean paymentDone;

    private String manufactureDone;
    private String deliveryStatus;

    @DocumentReference
    private List<Feedback> feedback;
 
}
