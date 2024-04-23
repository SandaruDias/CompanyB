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


import com.example.CompanyB.ManufacturingModule.Model.OnGoingOrder;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<OnGoingOrder,String>
{

}
