package com.example.CompanyB.ManufacturingModule.Repository;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchUser;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FetchUserRepository extends MongoRepository<FetchUser, String> {
    FetchUser findByUserName(String userName);
}