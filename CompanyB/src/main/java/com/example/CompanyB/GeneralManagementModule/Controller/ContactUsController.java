package com.example.CompanyB.GeneralManagementModule.Controller;

import com.example.CompanyB.GeneralManagementModule.Model.ContactUs;
import com.example.CompanyB.GeneralManagementModule.Service.ContactUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class ContactUsController {

    private final ContactUsService contactUsService;

    @Autowired
    public ContactUsController(ContactUsService contactUsService) {
        this.contactUsService = contactUsService;
    }

    //Getting Contact us request
    @PostMapping("/conusin")
    public ResponseEntity<ContactUs> contactusin(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email,@RequestParam String subject, @RequestParam String bodymsg) {
        try {
            ContactUs newContactUs = contactUsService.createContactUs(firstname, lastname, email, subject, bodymsg);
            return ResponseEntity.status(HttpStatus.CREATED).body(newContactUs);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    //Showing all Contactus response
    @GetMapping("/conusout")
    public ResponseEntity<List<ContactUs>> getallContactUs() {
        try {
            List<ContactUs> allResponses = (List<ContactUs>) contactUsService.getallContactUs();
            return ResponseEntity.ok(allResponses);
        } catch (Exception e) {
            // Handle exceptions or errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


}

