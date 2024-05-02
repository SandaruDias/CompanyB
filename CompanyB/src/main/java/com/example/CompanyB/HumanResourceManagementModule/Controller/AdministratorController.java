package com.example.CompanyB.HumanResourceManagementModule.Controller;

import com.example.CompanyB.HumanResourceManagementModule.Model.Administrator;
import com.example.CompanyB.HumanResourceManagementModule.Model.Employee;
import com.example.CompanyB.HumanResourceManagementModule.Service.AdministratorService;
import com.example.CompanyB.HumanResourceManagementModule.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("hr/administrator")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/create")
    public void createAdministrator(@RequestBody Administrator administrator){
        administratorService.createAdministrator(administrator);
    }

//    @GetMapping("info/{id}")
//    public Administrator getAdminInfo(@PathVariable String id){
//        return administratorService.getAdministratorById(id);
//    }

    @GetMapping("info/{id}")
    public ResponseEntity<Map<String, Object>> getAdminInfo(@PathVariable String id) {
        Administrator administrator = administratorService.getAdministratorById(id);
        if (administrator != null) {
            Map<String, Object> response = new HashMap<>();
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
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Administrator>> getAllAdmin() {
        List<Administrator> admin = administratorService.getAllAdmin();
        if(!admin.isEmpty()){
            return ResponseEntity.ok(admin);
        }
        else{
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/create/{employeeId}")
    public ResponseEntity<String> createAdministrator(@PathVariable String employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        if (employee != null) {
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
            String message = "Account creation successful";

            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } else {
            String message = "Resource not found. Please Try Again.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(message);
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteAdministrator(@PathVariable String id) {
        try {
            administratorService.deleteAdministrator(id);
            String message = "Account deleted successfully";
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .header("message", message)
                    .build();
        } catch (IllegalArgumentException e) {
            String errorMessage = "Invalid ID: " + id ;
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(errorMessage);
        }
    }

    //Method For Change Password


}
