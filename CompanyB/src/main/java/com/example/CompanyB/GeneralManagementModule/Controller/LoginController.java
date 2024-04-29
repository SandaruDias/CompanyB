package com.example.CompanyB.GeneralManagementModule.Controller;

import com.example.CompanyB.GeneralManagementModule.Model.User;
import com.example.CompanyB.GeneralManagementModule.Service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")

public class LoginController {

    private final UserServices userServices;

    @Autowired
    public LoginController(UserServices userServices) {
        this.userServices = userServices;
    }


    // Customer Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,@RequestParam String password) {

        if (userServices.authenticate(username, password)) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    // Customer registration
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String address, @RequestParam(required = false) Integer mobileno, @RequestParam String username, @RequestParam String password, @RequestParam(required = false) String role ) {
        try {
            User newUser = userServices.createUser( firstname, lastname, email, address, mobileno, username, password, role);
            return ResponseEntity.status(HttpStatus.CREATED).body(newUser); // User created successfully
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Username already exists
        }
    }

    //Get the User's data from database
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userServices.findByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
