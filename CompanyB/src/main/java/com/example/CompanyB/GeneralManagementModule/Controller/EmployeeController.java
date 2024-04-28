package com.example.CompanyB.GeneralManagementModule.Controller;

import com.example.CompanyB.GeneralManagementModule.Model.Employee;
import com.example.CompanyB.GeneralManagementModule.Model.User;
import com.example.CompanyB.GeneralManagementModule.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employee")

public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //Employee Login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username, @RequestParam String password) {
        if (employeeService.authenticate(username, password)) {
            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }

    //Employee Register
    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestParam String id, @RequestParam String firstname, @RequestParam String lastname, @RequestParam String email, @RequestParam String address, @RequestParam Integer mobileno, @RequestParam String username, @RequestParam String password, @RequestParam String role, @RequestParam double basicSalary, @RequestParam String joiningDate,
                                         @RequestParam String bankAccountNumber ) {
        try {
            Employee newEmployee = employeeService.createEmployee(id, firstname, lastname, email, address, mobileno, username, password, role, basicSalary, joiningDate, bankAccountNumber);
            return ResponseEntity.status(HttpStatus.CREATED).body(newEmployee); // User created successfully

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Username already exists
        }
    }

    //Get the data from data base
    @GetMapping("/{username}")
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = employeeService.findByUsername(username);
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
