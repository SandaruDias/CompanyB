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

import com.example.CompanyB.ManufacturingModule.Model.Post;
import com.example.CompanyB.ManufacturingModule.Model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

//import java.util.Optional;
//
//public interface PostRepository extends MongoRepository<Product, String> {
//    Optional<Product> findById(String id);
//}

public interface PostRepository extends MongoRepository<Post,String>
{

}
