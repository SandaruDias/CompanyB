package com.example.CompanyB.TrainingSimulationPrototypingModule.Repository;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee findBy_Id(String employeeId);
}
