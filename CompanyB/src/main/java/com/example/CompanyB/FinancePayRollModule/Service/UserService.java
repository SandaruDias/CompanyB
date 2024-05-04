package com.example.CompanyB.FinancePayRollModule.Service;
import com.example.CompanyB.FinancePayRollModule.Model.EmployeePayroll;
import com.example.CompanyB.FinancePayRollModule.Model.User;
import com.example.CompanyB.FinancePayRollModule.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    public User authenticateUser(String id, String password) {
        return userRepository.findByIdAndPassword(id, password);
    }


    public User getUserByEmployeeId(String employeeId) {  // New method
        return userRepository.findByEmployeeId(employeeId);
    }
}
