package com.example.CompanyB.HumanResourceManagementModule.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document("Administrator")
public class Administrator extends Person {
    @Id
    private String userId ;
    private String password;
}
