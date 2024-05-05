package com.example.CompanyB.GeneralManagementModule.Controller;

import com.example.CompanyB.GeneralManagementModule.Model.GMEmployee;
import com.example.CompanyB.GeneralManagementModule.Service.GMEmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/employee")
public class GMEmployeeController {

    private final GMEmployeeService GMEmployeeService;
    private static final Logger logger = LoggerFactory.getLogger(GMEmployeeController.class);

    @Autowired
    public GMEmployeeController(GMEmployeeService GMEmployeeService) {
        this.GMEmployeeService = GMEmployeeService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        try {
            logger.info("Login attempt for employee: {}", username);
            String token = GMEmployeeService.authenticate(username, password);
            logger.info("Employee logged in successfully: {}", username);
            //return ResponseEntity.ok(token);
            if (token != null)
                return ResponseEntity.ok("Login successful!");

            else
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        } catch (RuntimeException e) {
            logger.error("Login failed for employee: {}", username, e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<GMEmployee> register(@RequestParam String id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String address, @RequestParam Integer mobileno, @RequestParam String username, @RequestParam String password, @RequestParam String role, @RequestParam double basicSalary, @RequestParam String joiningDate,
                                               @RequestParam String bankAccountNumber) {
        try {
            logger.info("Registration attempt for employee: {}", username);
            GMEmployee newGMEmployee = GMEmployeeService.createEmployee(id, firstname, lastname, email, address, mobileno, username, password, role, basicSalary, joiningDate, bankAccountNumber);
            logger.info("Employee registered successfully: {}", username);
            return ResponseEntity.status(HttpStatus.CREATED).body(newGMEmployee);
        } catch (RuntimeException e) {
            logger.error("Registration failed for employee: {}", username, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @GetMapping("/{username}")
    public ResponseEntity<GMEmployee> getUserByUsername(@PathVariable String username) {
        GMEmployee GMEmployee = GMEmployeeService.findByUsername(username);
        if (GMEmployee != null) {
            return new ResponseEntity<>(GMEmployee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 Not Found when employee is not found
        }
    }

}