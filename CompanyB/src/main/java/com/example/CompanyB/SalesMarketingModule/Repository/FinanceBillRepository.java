package com.example.CompanyB.SalesMarketingModule.Repository;

import com.example.CompanyB.SalesMarketingModule.Model.FinanceBillModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceBillRepository extends MongoRepository<FinanceBillModel, String> {
    FinanceBillModel findByUserId(String userId);
    // You can add custom query methods if needed
}

