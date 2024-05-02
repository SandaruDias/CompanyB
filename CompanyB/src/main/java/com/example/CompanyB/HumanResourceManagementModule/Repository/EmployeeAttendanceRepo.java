package com.example.CompanyB.HumanResourceManagementModule.Repository;

import com.example.CompanyB.HumanResourceManagementModule.Model.EmployeeAttendanceModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeAttendanceRepo extends MongoRepository<EmployeeAttendanceModel, String > {
    // any extra methods
}
