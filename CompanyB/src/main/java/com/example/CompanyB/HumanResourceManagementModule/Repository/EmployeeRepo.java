package com.example.CompanyB.HumanResourceManagementModule.Repository;

import com.example.CompanyB.HumanResourceManagementModule.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends MongoRepository<Employee,String> {
}
