package com.example.CompanyB.SalesMarketingModule.Repository;

import com.example.CompanyB.SalesMarketingModule.Model.InventoryItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<InventoryItem, String> {
    // You can add custom query methods if needed
}
