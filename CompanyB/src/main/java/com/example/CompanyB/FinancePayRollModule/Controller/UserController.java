package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.EmployeePayroll;
import com.example.CompanyB.FinancePayRollModule.Model.User;
import com.example.CompanyB.FinancePayRollModule.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user = userService.getUserById(id);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/authenticate")
    public ResponseEntity<User> authenticateUser(@RequestBody User user) {
        User authenticatedUser = userService.authenticateUser(user.getId(), user.getPassword());
        return authenticatedUser != null ? ResponseEntity.ok(authenticatedUser) : ResponseEntity.status(401).build();
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<User> getUserByEmployeeId(@PathVariable String employeeId) {  // New endpoint
        User user = userService.getUserByEmployeeId(employeeId);
        return user != null ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
    }


}
