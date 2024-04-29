package com.example.CompanyB.GeneralManagementModule.Service;

import com.example.CompanyB.GeneralManagementModule.Model.User;
import com.example.CompanyB.GeneralManagementModule.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserServices {

    private final UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Find by username
    public User findByUsername(String username) {
        return userRepository.findByUserName(username);
    }

    //manual authentication
    public boolean authenticate(String username, String password) {
        User user = findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    //Create the user account
    public User createUser(String firstname, String lastname, String email, String address, Integer mobileno, String username, String password, String role) {
        // Check if the username is already taken
        if (userRepository.existsByUserName(username)) {
            throw new RuntimeException("Username already exists. Please choose a different username.");

        } else {
            // Create a new User entity
            User newUser = new User();
            newUser.setFirstName(firstname);
            newUser.setLastName(lastname);
            newUser.setEmail(email);
            newUser.setAddress(address);
            newUser.setMobileNo(mobileno);
            newUser.setUserName(username);
            newUser.setPassword(password);
            newUser.setRole(role);

            // Save the new user in the database
            return userRepository.save(newUser);
        }
    }
}


