package com.example.CompanyB.QualityAssuranceModule.Repository;

import com.example.CompanyB.QualityAssuranceModule.Model.MarkUpModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MarkUpModelRepository extends MongoRepository<MarkUpModel, String> {
}
