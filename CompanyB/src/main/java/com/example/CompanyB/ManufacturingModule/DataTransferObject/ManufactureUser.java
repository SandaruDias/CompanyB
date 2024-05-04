package com.example.CompanyB.ManufacturingModule.DataTransferObject;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Manufacturing_User")
public class ManufactureUser {
    @Id
    private String id;

    private String First_Name;
    private String Last_Name;
    private String Password;
    private String role;
    private String Contact_No;

    public ManufactureUser(String id, String first_Name, String last_Name, String password, String role, String contact_No) {
        this.id = id;
        First_Name = first_Name;
        Last_Name = last_Name;
        Password = password;
        this.role = role;
        Contact_No = contact_No;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContact_No() {
        return Contact_No;
    }

    public void setContact_No(String contact_No) {
        Contact_No = contact_No;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", First_Name='" + First_Name + '\'' +
                ", Last_Name='" + Last_Name + '\'' +
                ", Password='" + Password + '\'' +
                ", role='" + role + '\'' +
                ", Contact_No='" + Contact_No + '\'' +
                '}';
    }
}
