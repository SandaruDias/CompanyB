package com.example.CompanyB.GeneralManagementModule.Controller;


import com.example.CompanyB.GeneralManagementModule.Model.Subscribtion;
import com.example.CompanyB.GeneralManagementModule.Service.SubscribtionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/user")

public class SubscribtionController {

    private final SubscribtionService subscribtionService;

    @Autowired
    public SubscribtionController(SubscribtionService subscribtionService) {
        this.subscribtionService = subscribtionService;
    }

    // Subscription Input
    @PostMapping("/subin")
    public ResponseEntity<Subscribtion> createSubscribtion(@RequestParam String email) {
        try {
            Subscribtion newSuscribtion = subscribtionService.gettingSubscribtion(email);
            return ResponseEntity.status(HttpStatus.CREATED).body(newSuscribtion);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
    // Gett all subscription data from database
    @GetMapping("/subout")
    public ResponseEntity<List<Subscribtion>> getallsubscribtions() {
        try {
            List<Subscribtion> allResponses = (List<Subscribtion>) subscribtionService.getallsubscribtions();
            return ResponseEntity.ok(allResponses);
        } catch (Exception e) {
            // Handle exceptions or errors
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }
}


