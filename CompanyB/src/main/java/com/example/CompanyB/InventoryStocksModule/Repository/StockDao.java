package com.example.CompanyB.InventoryStocksModule.Repository;

import com.example.CompanyB.InventoryStocksModule.Model.stock;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
@Repository
public interface StockDao extends MongoRepository<stock, String> {
    stock findByName(String name);

    @Query(value = "{}", fields = "{ 'createdDateTime' : 1, 'updatedDateTime' : 1, 'updatedUser' : 1, 'id' : 1, 'name' : 1, 'units' : 1, 'suppliername' : 1, 'baseValue' : 1}")
    List<stock> findAllWithDetails();
}
