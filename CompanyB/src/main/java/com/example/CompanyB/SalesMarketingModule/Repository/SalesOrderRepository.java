package com.example.CompanyB.SalesMarketingModule.Repository;

import com.example.CompanyB.SalesMarketingModule.Model.SalesOrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesOrderRepository extends MongoRepository<SalesOrderModel, String> {
    // You can add custom query methods if needed
}

