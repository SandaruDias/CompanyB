package com.example.CompanyB.ManufacturingModule.Model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class Product {

    private String _id;
    private String releaseDate;

    // Getters and Setters
    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
