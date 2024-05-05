package com.example.CompanyB.TrainingSimulationPrototypingModule.Service;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.TPSEmployee;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Repository.TPSEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TPSEmployeeService {
    private final TPSEmployeeRepository TPSEmployeeRepository;

    @Autowired
    public TPSEmployeeService(TPSEmployeeRepository TPSEmployeeRepository) {
        this.TPSEmployeeRepository = TPSEmployeeRepository;
    }

    public TPSEmployee addEmployee(TPSEmployee TPSEmployee) {
        return TPSEmployeeRepository.save(TPSEmployee);
    }

    public TPSEmployee getEmployeeById(String employeeId) {
        return TPSEmployeeRepository.findBy_Id(employeeId);
    }

    public void selectCourseForEmployee(String employeeId, String courseId) {
        TPSEmployee TPSEmployee = TPSEmployeeRepository.findBy_Id(employeeId);
        if (TPSEmployee != null) {
            TPSEmployee.setSelectedCourseId(courseId);
            TPSEmployeeRepository.save(TPSEmployee);
        }
    }
}
