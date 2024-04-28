package com.example.CompanyB.GeneralManagementModule.Repository;

import com.example.CompanyB.GeneralManagementModule.Model.Subscribtion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SubscribtionRepository extends MongoRepository<Subscribtion, String> {
    boolean existsByEmail(String email);
}
