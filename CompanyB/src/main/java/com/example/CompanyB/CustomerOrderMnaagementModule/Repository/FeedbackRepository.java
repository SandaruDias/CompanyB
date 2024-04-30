package com.example.CompanyB.CustomerOrderMnaagementModule.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.CompanyB.CustomerOrderMnaagementModule.Model.Feedback;

@Repository
public interface FeedbackRepository extends MongoRepository<Feedback, ObjectId> {

    
}
