package com.example.CompanyB.GeneralManagementModule.Service;

import com.example.CompanyB.GeneralManagementModule.Model.ContactUs;
import com.example.CompanyB.GeneralManagementModule.Repository.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ContactUsService {

    private final ContactUsRepository contactUsRepository;

    @Autowired
    public ContactUsService(ContactUsRepository contactUsRepository) {
        this.contactUsRepository = contactUsRepository;
    }
    // Creating new contactus response
    public ContactUs createContactUs(String firstName, String lastName, String email, String subject, String bodymsg ) {
        ContactUs newContactUs = new ContactUs();
        newContactUs.setFirstName(firstName);
        newContactUs.setLastName(lastName);
        newContactUs.setEmail(email);
        newContactUs.setSubject(subject);
        newContactUs.setBodymsg(bodymsg);
        return contactUsRepository.save(newContactUs);
    }

    // Getting all contactus response method defining
    public List<ContactUs> getallContactUs() {
        return contactUsRepository.findAll();
    }
}
