package com.example.CompanyB.GeneralManagementModule.Repository;

import com.example.CompanyB.GeneralManagementModule.Model.ContactUs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContactUsRepository extends MongoRepository<ContactUs, String> {

}
