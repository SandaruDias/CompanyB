package com.example.CompanyB.CustomerOrderMnaagementModule.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.example.CompanyB.CustomerOrderMnaagementModule.Model.Feedback;
import com.example.CompanyB.CustomerOrderMnaagementModule.Model.OrderModel;
import com.example.CompanyB.CustomerOrderMnaagementModule.Repository.FeedbackRepository;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Feedback> allFeedbacks() {
        return feedbackRepository.findAll();

    }

    public Feedback createFeedback(String body,int ratings, String customerId) {
        Feedback feedback = feedbackRepository.insert(new Feedback(body,ratings,customerId));

        mongoTemplate.update(OrderModel.class)
        .matching(Criteria.where("customerID").is(customerId))
        .apply(new Update().push("feedback").value(feedback))
        .first();
            
        return feedback;

    }
    
}
