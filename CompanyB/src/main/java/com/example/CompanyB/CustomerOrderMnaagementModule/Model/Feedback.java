package com.example.CompanyB.CustomerOrderMnaagementModule.Model;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "Feedback")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Feedback {

    private ObjectId id;
    private String body;
    private int ratings;
    private long orderID;
    public Feedback(String body, int ratings, long orderID) {
        this.body = body;
        this.ratings = ratings;
        this.orderID = orderID;
    }
    
    
    

    
    
    
}
