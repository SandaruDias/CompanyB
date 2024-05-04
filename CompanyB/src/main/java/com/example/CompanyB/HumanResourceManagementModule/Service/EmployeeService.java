package com.example.CompanyB.HumanResourceManagementModule.Service;

import com.example.CompanyB.HumanResourceManagementModule.Model.Employee;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    // Method to create a new employee
    public void createEmploy(Employee employee){
        employeeRepo.save(employee);
    }

    // Method to retrieve all employees
    public List<Employee> getAllEmploy(){
        return employeeRepo.findAll();
    }

    // Method to get the division of an employee by ID
    public String getEmpDivision(String id){
        boolean isPresent = employeeRepo.findById(id).isPresent();
        if (isPresent) {
            return employeeRepo.findById(id).get().getDivision();
        } else {
            return "Enter correct id";
        }
    }

    // Method to update salary information for an employee
    public void updateEmployeeSalaryInfo(String id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();

            // Update salary-related fields
            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setAllowance(updatedEmployee.getAllowance());
            existingEmployee.setOtRate(updatedEmployee.getOtRate());
            existingEmployee.setWorkingDays(updatedEmployee.getWorkingDays());

            // Save the updated employee
            employeeRepo.save(existingEmployee);
        }
    }

    // Method to delete an employee by ID
    public void deleteEmployeeById(String id) {
        employeeRepo.deleteById(id);
    }

    // Method to get the course level of an employee by ID
    public String getCourseLevelById(String id) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get().getCourseLevel();
        } else {
            return "Employee not found";
        }
    }

    // Method to update the course level for an employee by ID
    public void updateEmployeeCourseLevel(String id, String newLevel) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setCourseLevel(newLevel);
            employeeRepo.save(existingEmployee);
        }
    }

    // Method to get an employee by ID
    public Employee getEmployeeById(String id) {
        return employeeRepo.findById(id).orElse(null);
    }
}

