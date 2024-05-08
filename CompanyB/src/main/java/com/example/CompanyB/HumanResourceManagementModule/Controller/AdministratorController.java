package com.example.CompanyB.HumanResourceManagementModule.Controller;

import com.example.CompanyB.HumanResourceManagementModule.Model.Administrator;
import com.example.CompanyB.HumanResourceManagementModule.Model.Employee;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployeeAttendanceRepo;
import com.example.CompanyB.HumanResourceManagementModule.Service.AdministratorService;
import com.example.CompanyB.HumanResourceManagementModule.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hr/administrator")
@CrossOrigin
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeAttendanceRepo employeeAttendanceRepo;

    // Endpoint to create a new administrator
    @PostMapping("/create")
    public ResponseEntity<String> createAdministrator(@RequestBody Administrator administrator) {
        administratorService.createAdministrator(administrator);
        return ResponseEntity.ok("Administrator created successfully.");
    }

    // Endpoint to get administrator information by ID
    @GetMapping("info/{id}")
    public ResponseEntity<Map<String, Object>> getAdminInfo(@PathVariable String id) {
        Administrator administrator = administratorService.getAdministratorById(id);
        if (administrator != null) {
            // Prepare response with administrator information
            Map<String, Object> response = new HashMap<>();
            response.put("userID", administrator.getUserId());
            response.put("firstName", administrator.getFirstName());
            response.put("lastName", administrator.getLastName());
            response.put("nicNo", administrator.getNicNo());
            response.put("birthDay", administrator.getBirthDay());
            response.put("mobileNo", administrator.getMobileNo());
            response.put("gender", administrator.getGender());
            response.put("email", administrator.getEmail());
            response.put("isMarried", administrator.getIsMarried());
            response.put("position", administrator.getPosition());
            response.put("division", administrator.getDivision());
            return ResponseEntity.ok(response);
        } else {
            // Return 404 Not Found if administrator is not found
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to get all administrators
    @GetMapping("/getAll")
    public ResponseEntity<List<Administrator>> getAllAdmin() {
        List<Administrator> admin = administratorService.getAllAdmin();
        if(!admin.isEmpty()){
            return ResponseEntity.ok(admin);
        } else {
            // Return 404 Not Found if no administrators are found
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to create an administrator based on an employee ID
    @PostMapping("/create/{employeeId}")
    public ResponseEntity<String> createAdministrator(@PathVariable String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
            // Create new administrator based on employee information
            Administrator administrator = new Administrator();
            administrator.setUserId(employeeId);
            administrator.setFirstName(employee.getFirstName());
            administrator.setLastName(employee.getLastName());
            administrator.setNicNo(employee.getNicNo());
            administrator.setBirthDay(employee.getBirthDay());
            administrator.setMobileNo(employee.getMobileNo());
            administrator.setAddress(employee.getAddress());
            administrator.setGender(employee.getGender());
            administrator.setEmail(employee.getEmail());
            administrator.setPosition(employee.getPosition());
            administrator.setDivision(employee.getDivision());
            administrator.setPassword("login123");
            administratorService.createAdministrator(administrator);
            return ResponseEntity.ok("Administrator created successfully.");
        } else {
            // Return 404 Not Found if employee with given ID is not found
            return ResponseEntity.notFound().build();
        }
    }

    // Endpoint to delete an administrator by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdministrator(@PathVariable String id) {
        boolean isDeleted = administratorService.deleteAdministrator(id);
        if (isDeleted) {
            return ResponseEntity.ok("Administrator with ID " + id + " has been successfully deleted.");
        } else {
            return ResponseEntity.ok("Administrator with ID " + id + " was not found.");
        }
    }

    // granting the permission for short leaves at the specified time by the administrator
    @GetMapping("/attendancePermission/{id}")
    public String getPermission(@PathVariable String id) {
        if (administratorService.getPermission(id)) {
            return "Short leave permission granted for id:" + id;
        }else {
            return "Your ID " + id + " is not found in the attendance tracker.";
        }
    }
}

