package com.example.CompanyB.InventoryStocksModule.Repository;

import com.example.CompanyB.InventoryStocksModule.Model.OrderDetail;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao extends MongoRepository<OrderDetail, String> {
    // OrderDetail findByName(String name);
}
