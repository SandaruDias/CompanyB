package com.example.CompanyB.GeneralManagementModule.Controller;

import com.example.CompanyB.GeneralManagementModule.Model.Employee;
import com.example.CompanyB.GeneralManagementModule.Service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        try {
            logger.info("Login attempt for employee: {}", username);
            String token = employeeService.authenticate(username, password);
            logger.info("Employee logged in successfully: {}", username);
            return ResponseEntity.ok(token);
        } catch (RuntimeException e) {
            logger.error("Login failed for employee: {}", username, e);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Employee> register(@RequestParam String id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String address, @RequestParam Integer mobileno, @RequestParam String username, @RequestParam String password, @RequestParam String role, @RequestParam double basicSalary, @RequestParam String joiningDate,
                                             @RequestParam String bankAccountNumber) {
        try {
            logger.info("Registration attempt for employee: {}", username);
            Employee newEmployee = employeeService.createEmployee(id, firstname, lastname, email, address, mobileno, username, password, role, basicSalary, joiningDate, bankAccountNumber);
            logger.info("Employee registered successfully: {}", username);
            return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee);
        } catch (RuntimeException e) {
            logger.error("Registration failed for employee: {}", username, e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


    @GetMapping("/{username}")
    public ResponseEntity<Employee> getUserByUsername(@PathVariable String username) {
        Employee employee = employeeService.findByUsername(username);
        if (employee != null) {
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 Not Found when employee is not found
        }
    }

}