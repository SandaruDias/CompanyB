package com.example.CompanyB.HumanResourceManagementModule.Controller;

import com.example.CompanyB.HumanResourceManagementModule.Model.Employee;
import com.example.CompanyB.HumanResourceManagementModule.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/hr/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public ResponseEntity<String> createEmploy(@RequestBody Employee employee1){
        employeeService.createEmploy(employee1);
        String successMessage = "Account created successfully . " ;
        return ResponseEntity.status(HttpStatus.CREATED).body(successMessage);
    }

    @GetMapping("/getEmploy/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        } else {
            return ResponseEntity.ok(employee);
        }
    }


    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmploy();
        return ResponseEntity.ok(employees);
    }

    @PatchMapping("/updateSalaryInfo/{id}")
    public ResponseEntity<String> updateEmployeeAttendance(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        try {
            employeeService.updateEmployeeSalaryInfo(id, updatedEmployee);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid ID: " + id);
        }
    }

    @GetMapping("/getEmpDivision/{id}")
    public ResponseEntity<String> getEmpDivision(@PathVariable String id) {
        String division;
        try {
            division = employeeService.getEmpDivision(id);
            if (division == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Division not found for ID: " + id);
            } else {
                return ResponseEntity.ok(division);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error retrieving division for ID: " + id);
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String id) {
        try {
            employeeService.deleteEmployeeById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("deleted account: " + id);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Invalid ID: " + id);
        }
    }

    @GetMapping("/getCourseLevel/{id}")
    public ResponseEntity<Map<String, Object>> getPositionById(@PathVariable String id) {
        try {
            int courseLevel = employeeService.getCourseLevelById(id);
            String division = employeeService.getEmpDivision(id);

            // Create response map with appropriate data types
            Map<String, Object> response = new HashMap<>();
            response.put("id", id);
            response.put("courseLevel", courseLevel); // Store courseLevel as integer
            response.put("division", division);

            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Collections.singletonMap("error", e.getMessage()));
        }
    }


    @PatchMapping("/updateLevel")
    public ResponseEntity<String> updateEmployeePosition(@RequestParam String id, @RequestParam Integer Level) {
        employeeService.updateEmployeeCourseLevel(id, Level);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
