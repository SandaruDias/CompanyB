package com.example.CompanyB.CustomerOrderMnaagementModule.Repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.CompanyB.CustomerOrderMnaagementModule.Model.OrderModel;

@Repository
public interface OrderRepository extends MongoRepository<OrderModel, ObjectId> {
    Optional<OrderModel> findOrderByCustomerID(String customerID);
}
