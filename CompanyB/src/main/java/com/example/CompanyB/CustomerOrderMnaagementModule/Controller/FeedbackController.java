package com.example.CompanyB.CustomerOrderMnaagementModule.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CompanyB.CustomerOrderMnaagementModule.Model.Feedback;

import com.example.CompanyB.CustomerOrderMnaagementModule.Service.FeedbackService;

@RestController
@RequestMapping("customer/review")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<Feedback>> getallFeedbacks() {
        return new ResponseEntity<List<Feedback>>(feedbackService.allFeedbacks(), HttpStatus.OK);
    }


    @PostMapping("/{orderID}")
    public ResponseEntity<Feedback> createFeedback(@RequestBody Feedback feedback, @PathVariable long orderID) {
        return new ResponseEntity<Feedback>(
                feedbackService.createFeedback(feedback.getBody(),feedback.getRatings(),orderID),
                HttpStatus.CREATED);
    }

}
