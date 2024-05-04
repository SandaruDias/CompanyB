package com.example.CompanyB.QualityAssuranceModule.Repository;

import com.example.CompanyB.QualityAssuranceModule.Model.Prototype;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PrototypeRepository extends MongoRepository<Prototype, String> {
}
