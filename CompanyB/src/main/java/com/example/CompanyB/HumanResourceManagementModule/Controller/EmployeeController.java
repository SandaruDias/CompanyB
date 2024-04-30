package com.example.CompanyB.HumanResourceManagementModule.Controller;

import com.example.CompanyB.HumanResourceManagementModule.Model.Employee;
import com.example.CompanyB.HumanResourceManagementModule.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hr/employ")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public void createEmploy(@RequestBody Employee employee1){
        employeeService.createEmploy(employee1);
    }

    @GetMapping("/getEmploy/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmploy();
        return ResponseEntity.ok(employees);
    }

    @PatchMapping("/updateSalaryInfo/{id}")
    public ResponseEntity<String> updateEmployeeAttendance(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        employeeService.updateEmployeeSalaryInfo(id, updatedEmployee);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/getDivision/{id}")
    public String getEmpDivision(@PathVariable String id){
        return employeeService.getEmpDivision(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/getCourseLevel/{id}")
    public ResponseEntity<Map<String, String>> getPositionById(@PathVariable String id) {
        Map<String, String> response = new HashMap<>();
        String level = employeeService.getCourseLevelById(id);
        response.put("id", id);
        response.put("courseLevel", level);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/updatePosition/{id}")
    public ResponseEntity<String> updateEmployeePosition(@PathVariable String id, @RequestParam String newLevel) {
        employeeService.updateEmployeeCourseLevel(id, newLevel);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
