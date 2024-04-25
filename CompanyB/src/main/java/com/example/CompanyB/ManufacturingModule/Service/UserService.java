package com.example.CompanyB.ManufacturingModule.Service;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.User;
import com.example.CompanyB.ManufacturingModule.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;



@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository){
        this.userRepository =userRepository;
    }
    public boolean Login(String userId,String password ){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Invalid User Name"));
        //if(password == user.g)
        return false;
    }
}
