package com.example.CompanyB.GeneralManagementModule.Model;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Subscription_Data")
@Getter
@Setter
public class Subscribtion {

    @NonNull
    @Email
    private String email;

    public Subscribtion() {

    }
    //Constructor
    public Subscribtion(String email) {
        this.email = email;
    }


}
