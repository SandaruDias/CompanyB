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

import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchOrder;
import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchWorksStationUser;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchWorksStationUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FetchWorkStationUserRepository extends MongoRepository<FetchWorksStationUser, String> {

    FetchWorksStationUser findByWorkStationId(int workStationId);
}