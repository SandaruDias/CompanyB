package com.example.CompanyB.TrainingSimulationPrototypingModule.Service;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.Course;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.Employee;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Repository.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployeeById(String employeeId) {
        return employeeRepository.findByEmployeeId(employeeId);
    }

    public void selectCourseForEmployee(String employeeId, int skillLevel) {
        Employee employee = employeeRepository.findByEmployeeId(employeeId);
        if (employee != null) {
            //
            Course selectedCourse = CourseService.getCourseBySkillLevel(skillLevel);
            if (selectedCourse != null) {
                employee.setSelectedCourse();
                employeeRepository.save(employee);
            }
        }
    }

}
