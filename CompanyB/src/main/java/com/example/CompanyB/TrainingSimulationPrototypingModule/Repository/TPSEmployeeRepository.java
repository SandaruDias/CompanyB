package com.example.CompanyB.TrainingSimulationPrototypingModule.Repository;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.TPSEmployee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TPSEmployeeRepository extends MongoRepository<TPSEmployee, String> {
    TPSEmployee findBy_Id(String employeeId);
}
