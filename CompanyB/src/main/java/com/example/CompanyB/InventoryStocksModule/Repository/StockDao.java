package com.example.CompanyB.InventoryStocksModule.Repository;

import com.example.CompanyB.InventoryStocksModule.Model.stock1;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.Query;
import java.util.List;
@Repository
public interface StockDao extends MongoRepository<stock1, String> {
    stock1 findByName(String name);

    @Query(value = "{}", fields = "{ 'createdDate' : 1, 'updatedDate' : 1, 'updatedUser' : 1, 'id' : 1, 'name' : 1, 'units' : 1, 'suppliername' : 1, 'baseValue' : 1}")
    List<stock1> findAllWithDetails();
}
