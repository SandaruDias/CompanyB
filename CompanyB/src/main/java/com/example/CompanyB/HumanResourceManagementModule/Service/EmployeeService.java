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

    public void createEmploy(Employee employee){
        employeeRepo.save(employee);
    }

    public List<Employee> getAllEmploy(){
        return employeeRepo.findAll();
    }

    public  String getEmpDivision(String id){
        boolean iaTrue =employeeRepo.findById(id).isPresent();
        if(iaTrue){
            return employeeRepo.findById(id).get().getDivision();
        }else{
            return "Enter correct id";
        }
    }

    public void updateEmployeeSalaryInfo(String id, Employee updatedEmployee) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();

            existingEmployee.setSalary(updatedEmployee.getSalary());
            existingEmployee.setAllowance(updatedEmployee.getAllowance());
            existingEmployee.setOtRate(updatedEmployee.getOtRate());
            existingEmployee.setWorkingDays(updatedEmployee.getWorkingDays());

            employeeRepo.save(existingEmployee);
        }
    }

    public void deleteEmployeeById(String id) {
        employeeRepo.deleteById(id);
    }

    public String getCourseLevelById(String id) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            return optionalEmployee.get().getCourseLevel();
        } else {
            return "Employee not found";
        }
    }

    public void updateEmployeeCourseLevel(String id, String newlevel) {
        Optional<Employee> optionalEmployee = employeeRepo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee existingEmployee = optionalEmployee.get();
            existingEmployee.setCourseLevel(newlevel);
            employeeRepo.save(existingEmployee);
        }
    }

    public Employee getEmployeeById(String id) {
        return employeeRepo.findById(id).orElse(null);
    }


}
