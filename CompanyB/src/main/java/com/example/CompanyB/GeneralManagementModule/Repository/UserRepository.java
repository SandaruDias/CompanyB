package com.example.CompanyB.GeneralManagementModule.Repository;

import com.example.CompanyB.GeneralManagementModule.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends MongoRepository<User, String> {
    User findByUserName(String userName);
    boolean existsById(String id);
    boolean existsByUserName(String username);
}