package com.example.CompanyB.InventoryStocksModule.Service;

import com.example.CompanyB.InventoryStocksModule.Repository.UserDao;
import com.example.CompanyB.InventoryStocksModule.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public boolean authenticateUser(String username, String password) {
        User user = userDao.findByUsernameAndPassword(username, password);
        return user != null;
    }
}
