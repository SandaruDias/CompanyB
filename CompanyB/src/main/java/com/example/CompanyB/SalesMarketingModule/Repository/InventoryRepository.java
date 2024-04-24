package com.example.CompanyB.SalesMarketingModule.Repository;

import com.example.CompanyB.SalesMarketingModule.Model.InventoryItem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<InventoryItem, String> {

    @Query("{ 'item_id' : ?0 }")
    InventoryItem findByItem_id(String itemId);
    // You can add custom query methods if needed
}
