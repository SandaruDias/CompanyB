package com.example.CompanyB.SalesMarketingModule.Repository;

import com.example.CompanyB.SalesMarketingModule.Model.OrderModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<OrderModel, String> {
    // You can add custom query methods if needed
}

