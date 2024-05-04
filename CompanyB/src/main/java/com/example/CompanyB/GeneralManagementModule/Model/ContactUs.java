package com.example.CompanyB.GeneralManagementModule.Model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//Database collection :- ContactUs_Data
@Document(collection = "ContactUs_Data")
@Getter
@Setter

public class ContactUs {

    @Id
    @NonNull
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String email;
    @NonNull
    private String subject;
    @NonNull
    private String bodymsg;



    // Constructor
    public ContactUs() {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.subject = subject;
        this.bodymsg = bodymsg;
    }
}
