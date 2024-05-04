package com.example.CompanyB.GeneralManagementModule.Model;

import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customers _Data")
@Getter
@Setter

public class User {

    @Id
    @NonNull
    private String id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    @Email(message = "Please enter valid Email")
    private String email;
    @NonNull
    private String address;
    @NonNull
    private Integer mobileNo;
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @NonNull
    private String role;

    public User() {
    }

    public User(String id, String firstName, String lastName, String email, String address, Integer mobileNo, String userName, String password, String role) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.mobileNo = mobileNo;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", mobileNo=" + mobileNo +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

}
