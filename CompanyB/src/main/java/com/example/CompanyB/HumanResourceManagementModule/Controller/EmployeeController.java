
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

    // Endpoint to create a new employee
    @PostMapping("/create")
    public void createEmploy(@RequestBody Employee employee1) {
        employeeService.createEmploy(employee1);
    }

    // Endpoint to get an employee by ID
    @GetMapping("/getEmploy/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee == null) {
            // Return 404 Not Found if employee is not found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } else {
            // Return the employee object if found
            return ResponseEntity.ok(employee);
        }
    }

    // Endpoint to get all employees
    @GetMapping("/getAll")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmploy();
        return ResponseEntity.ok(employees);
    }

    // Endpoint to update salary info for an employee
    @PatchMapping("/updateSalaryInfo/{id}")
    public ResponseEntity<String> updateEmployeeAttendance(@PathVariable String id, @RequestBody Employee updatedEmployee) {
        boolean updated = employeeService.updateEmployeeSalaryInfo(id, updatedEmployee);

        if (updated) {
            return ResponseEntity.ok("Employee salary info updated successfully");
        } else {
            return ResponseEntity.notFound().build(); // Return 404 if employee is not found
        }
    }

    // Endpoint to get the division of an employee by ID
    @GetMapping("/getDivision/{id}")
    public String getEmpDivision(@PathVariable String id) {
        return employeeService.getEmpDivision(id);
    }

    // Endpoint to delete an employee by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable String id) {
        boolean deleted = employeeService.deleteEmployeeById(id);

        if (deleted) {
            // If employee is successfully deleted, return HTTP 200 (OK) with a success message
            return ResponseEntity.ok("Employee with ID " + id + " has been deleted successfully");
        } else {
            // If employee is not found or deletion fails, return HTTP 404 (Not Found) with an error message
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Employee with ID " + id + " not found");
        }
    }

    // Endpoint to get course level and division of an employee by ID
    @GetMapping("/getCourseLevel/{id}")
    public ResponseEntity<Map<String, String>> getPositionById(@PathVariable String id) {
        Map<String, String> response = new HashMap<>();
        String level = employeeService.getCourseLevelById(id);
        String division = employeeService.getEmpDivision(id);
        response.put("id", id);
        response.put("courseLevel", level);
        response.put("division", division != null ? division : "Employee not found");
        return ResponseEntity.ok(response);
    }

    // Endpoint to update course level for an employee by ID
    @PutMapping("/updateCourseLevel/{id}/{newLevel}")
    public ResponseEntity<String> updateEmployeeCourseLevel(@PathVariable String id, @PathVariable String newLevel) {
        boolean updated = employeeService.updateEmployeeCourseLevel(id, newLevel);

        if (updated) {
            String successMessage = "Course level updated for employee with ID " + id + " to " + newLevel;
            return ResponseEntity.ok(successMessage);
        } else {
            return ResponseEntity.notFound().build(); //
        }
    }
}
