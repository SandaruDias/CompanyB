package com.example.CompanyB.QualityAssuranceModule.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.CompanyB.QualityAssuranceModule.Model.QAProduct;

@Repository
public interface QAProductRepository extends MongoRepository<QAProduct,String> {
    QAProduct findByProductId(String productId);
}
