package com.example.CompanyB.GeneralManagementModule.Controller;

import com.example.CompanyB.GeneralManagementModule.Model.User;
import com.example.CompanyB.GeneralManagementModule.Service.AuthenticationService;
import com.example.CompanyB.GeneralManagementModule.Service.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class for handling user authentication and registration.
 */
@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class LoginController {

    private final UserServices userServices;
    private final AuthenticationService authenticationService;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);


    /**
     * Constructor injection for dependencies.
     *
     * @param userServices          Service for user-related operations.
     * @param authenticationService Service for authentication.
     */
    @Autowired
    public LoginController(UserServices userServices, AuthenticationService authenticationService) {
        this.userServices = userServices;
        this.authenticationService = authenticationService;
    }

    /**
     * Endpoint for user login.
     *
     * @param username User's username.
     * @param password User's password.
     * @return ResponseEntity containing authentication token if successful, else error message.
     */
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        try {
            logger.info("Login attempt for user: {}", username);
            String token = authenticationService.authenticate(username, password);
            logger.info("User logged in successfully: {}", username);
              //return ResponseEntity.ok(token);
                if (token != null)
                    return ResponseEntity.ok("Login successful!");

                else
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        } catch (RuntimeException e) {
            logger.error("Login failed for user: {}", username, e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


    /**
     * Endpoint for user registration.
     *
     * @param firstname User's first name.
     * @param lastname  User's last name.
     * @param email     User's email.
     * @param address   User's address.
     * @param mobileno  User's mobile number.
     * @param username  User's username.
     * @param password  User's password.
     * @param role      User's role (optional).
     * @return ResponseEntity containing newly created user if successful, else error message.
     */
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String address, @RequestParam(required = false) Integer mobileno, @RequestParam String username, @RequestParam String password, @RequestParam(required = false) String role) {
        try {
            logger.info("Registration attempt for user: {}", username);

            User newUser = userServices.createUser(firstname, lastname, email, address, mobileno, username, password, role);

            logger.info("User registered successfully: {}", username);

            return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
        } catch (RuntimeException e) {
            logger.error("Registration failed for user: {}", username, e);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    /**
     * Endpoint to retrieve user's data by username.
     *
     * @param username User's username.
     * @return ResponseEntity containing user data if found, else error message.
     */
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