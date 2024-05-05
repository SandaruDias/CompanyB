package com.example.CompanyB.QualityAssuranceModule.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.CompanyB.QualityAssuranceModule.Model.Reviews;

@Repository
public interface ReviewRepository extends MongoRepository<Reviews,String>{

}
