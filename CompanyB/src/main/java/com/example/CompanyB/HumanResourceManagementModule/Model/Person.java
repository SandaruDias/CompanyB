package com.example.CompanyB.HumanResourceManagementModule.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Person {
    private String firstName;
    private String lastName;
    private String nicNo;
    private String birthDay;
    private String mobileNo;
    private String Address ;
    private String gender ;
    private String email;
    private Boolean isMarried;
    private String position;
    private String division;
}
