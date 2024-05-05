package com.example.CompanyB.QualityAssuranceModule.Repository;

import com.example.CompanyB.QualityAssuranceModule.Model.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends MongoRepository<Manager,String> {
    Manager findByReviewId(String reviewId);

}