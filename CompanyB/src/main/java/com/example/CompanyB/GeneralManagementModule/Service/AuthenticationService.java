package com.example.CompanyB.GeneralManagementModule.Service;

import com.example.CompanyB.GeneralManagementModule.Model.GMEmployee;
import com.example.CompanyB.GeneralManagementModule.Model.User;
import com.example.CompanyB.GeneralManagementModule.Repository.GMEmployeeRepository;
import com.example.CompanyB.GeneralManagementModule.Repository.UserRepository;
import com.example.CompanyB.GeneralManagementModule.Util.JwtUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private GMEmployeeRepository GMEmployeeRepository;

    public String authenticate(String username, String password) {
        try {
            logger.info("Authentication attempt for user: {}", username);
            User user = userRepository.findByUserName(username);
            logger.info("Found the user from DB: {}", username);
            if (user != null && user.getPassword().equals(password)) {
                logger.info("🚀 - Log at user != null && user.getPassword().equals(password)", username);
                String token = jwtUtil.generateToken(user.getUserName());
                logger.info("User authenticated successfully: {}", username);

                return token;
            } else {
                logger.error("Authentication failed for user: {}", username);
                throw new RuntimeException("Incorrect username or password");
            }
        } catch (Exception e) {
            logger.error("Authentication failed due to exception for user: {}", username, e);
            throw new RuntimeException("Authentication failed due to an unexpected error");
        }
    }

    // Modify AuthenticationService to include a method for authenticating employees.
    public String authenticateEmployee(String username, String password) {
        try {
            logger.info("Authentication attempt for employee: {}", username);
            GMEmployee GMEmployee = GMEmployeeRepository.findByUserName(username);
            if (GMEmployee != null && GMEmployee.getPassword().equals(password)) {
                String token = jwtUtil.generateToken(GMEmployee.getUserName());
                logger.info("Employee authenticated successfully: {}", username);
                return token;
            } else {
                logger.error("Authentication failed for employee: {}", username);
                throw new RuntimeException("Incorrect username or password for employee");
            }
        } catch (Exception e) {
            logger.error("Authentication failed due to exception for employee: {}", username, e);
            throw new RuntimeException("Authentication failed due to an unexpected error for employee");
        }
    }

}