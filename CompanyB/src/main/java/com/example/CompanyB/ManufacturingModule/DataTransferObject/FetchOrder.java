package com.example.CompanyB.ManufacturingModule.DataTransferObject;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Document(collection = "OrderDetail")
public class FetchOrder {
    @Id
    private String id; //primary key

    private int quantity;

    public String getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Order to fetch{" +
                "id='" + id + '\'' +
                ", quantity='" + quantity +
                '}';
    }
}
