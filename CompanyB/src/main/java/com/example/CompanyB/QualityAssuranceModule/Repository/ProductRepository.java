package com.example.CompanyB.QualityAssuranceModule.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.CompanyB.QualityAssuranceModule.Model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product,String> {
    Product findByProductId(String productId);
}
