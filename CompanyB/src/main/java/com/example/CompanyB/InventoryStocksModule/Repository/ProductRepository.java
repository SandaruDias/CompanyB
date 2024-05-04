package com.example.CompanyB.InventoryStocksModule.Repository;

import com.example.CompanyB.InventoryStocksModule.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{ '_id': ?0 }")
    Product findProductById(String Id);
}
