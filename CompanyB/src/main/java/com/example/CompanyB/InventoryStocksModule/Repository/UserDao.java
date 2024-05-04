package com.example.CompanyB.InventoryStocksModule.Repository;

import com.example.CompanyB.InventoryStocksModule.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends MongoRepository<User, String> {

    User findByUsernameAndPassword(String username, String password);
}
