package com.example.CompanyB.FinancePayRollModule.Repository;
import com.example.CompanyB.FinancePayRollModule.Model.EmployeePayroll;
import com.example.CompanyB.FinancePayRollModule.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    User findByIdAndPassword(String id, String password);
    User findByEmployeeId(String employeeId);
}
