package com.example.CompanyB.GeneralManagementModule.Model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "Administrative_Data")

public class GMEmployee extends User {
    @NonNull
    private double basicSalary;
    @NonNull
    private String joiningDate;
    @NonNull
    private String bankAccountNumber;

    public GMEmployee() {}

    // Constructor
    public GMEmployee(String id, String firstName, String lastName, String email, String address,
                      Integer mobileNo, String userName, String password, String role,
                      double basicSalary, String joiningDate, String bankAccountNumber) {
        super(id, firstName, lastName, email, address, mobileNo, userName, password, role);
        this.basicSalary = basicSalary;
        this.joiningDate = joiningDate;
        this.bankAccountNumber = bankAccountNumber;
    }

}
