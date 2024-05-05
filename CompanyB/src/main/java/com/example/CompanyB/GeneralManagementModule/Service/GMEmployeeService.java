package com.example.CompanyB.GeneralManagementModule.Service;

import com.example.CompanyB.GeneralManagementModule.Model.GMEmployee;
import com.example.CompanyB.GeneralManagementModule.Repository.GMEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class GMEmployeeService {

    private final GMEmployeeRepository GMEmployeeRepository;
    private final AuthenticationService authenticationService;

    @Autowired
    public GMEmployeeService(GMEmployeeRepository GMEmployeeRepository, AuthenticationService authenticationService) {
        this.GMEmployeeRepository = GMEmployeeRepository;
        this.authenticationService = authenticationService;
    }

    //Finding by username
    public GMEmployee findByUsername(String username) {
        return GMEmployeeRepository.findByUserName(username);
    }

    //Manual authentication system
    // Use AuthenticationService for JWT handling
    public String authenticate(String username, String password) {
        return authenticationService.authenticateEmployee(username, password);  // Redirect authentication to AuthenticationService
    }


    //Save the new response
    public GMEmployee createEmployee(String id, String firstname, String lastname, String email,
                                     String address, Integer mobileno, String username, String password,
                                     String role, double basicSalary, String joiningDate,
                                     String bankAccountNumber) {

        // Check if the username is already taken
        if (GMEmployeeRepository.existsByUserName(username)) {
            throw new RuntimeException("Username already exists. Please choose a different username.");
        } else if (GMEmployeeRepository.existsById(id)) {
            throw new RuntimeException("ID already exists. Please choose a different ID.");
        } else {


            // Create a new Employee entity
            GMEmployee newGMEmployee = new GMEmployee();
            newGMEmployee.setId(id);
            newGMEmployee.setFirstName(firstname);
            newGMEmployee.setLastName(lastname);
            newGMEmployee.setEmail(email);
            newGMEmployee.setAddress(address);
            newGMEmployee.setMobileNo(mobileno);
            newGMEmployee.setUserName(username);
            newGMEmployee.setPassword(password);
            newGMEmployee.setRole(role);
            newGMEmployee.setBasicSalary(basicSalary);
            newGMEmployee.setJoiningDate(joiningDate);
            newGMEmployee.setBankAccountNumber(bankAccountNumber);

            // Save the new employee in the database
            return GMEmployeeRepository.save(newGMEmployee);
        }
    }

}
