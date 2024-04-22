//package com.example.CompanyB.ManufacturingModule.Repository;
//
//
//import org.springframework.data.mongodb.repository.MongoRepository;
//import com.example.CompanyB.ManufacturingModule.Model.Product;
//
//public interface ProductRepository extends MongoRepository<Product, String> {
//    Product getId(String id);
//}

package com.example.CompanyB.ManufacturingModule.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.CompanyB.ManufacturingModule.Model.Product;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
    Optional<Product> findById(String id);
}
