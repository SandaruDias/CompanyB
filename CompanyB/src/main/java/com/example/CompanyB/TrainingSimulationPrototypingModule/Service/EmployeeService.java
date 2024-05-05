package com.example.CompanyB.TrainingSimulationPrototypingModule.Service;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.Employee;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(String employeeId) {
        return employeeRepository.findBy_Id(employeeId);
    }

    public void selectCourseForEmployee(String employeeId, String courseId) {
        Employee employee = employeeRepository.findBy_Id(employeeId);
        if (employee != null) {
            employee.setSelectedCourseId(courseId);
            employeeRepository.save(employee);
        }
    }
}
