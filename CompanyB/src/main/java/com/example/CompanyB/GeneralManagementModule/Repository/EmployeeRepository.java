package com.example.CompanyB.GeneralManagementModule.Repository;

import com.example.CompanyB.GeneralManagementModule.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmployeeRepository extends MongoRepository<Employee,String> {
    Employee findByUserName(String username);
    boolean existsById(String id);
    boolean existsByUserName(String username);

}
