package com.example.CompanyB.HumanResourceManagementModule.Controller;

import com.example.CompanyB.HumanResourceManagementModule.Service.EmployeeAttendanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("hr/employee/attendance")
public class EmployeeAttendanceController {

    private EmployeeAttendanceService employeeAttendanceService;

    // dependency injection
    public EmployeeAttendanceController(EmployeeAttendanceService employeeAttendanceService) {
        this.employeeAttendanceService = employeeAttendanceService;
    }

    @PostMapping("/check-in/{id}")
    public ResponseEntity<String> checkIn(@PathVariable String id) {
        // Get the current timestamp
        LocalDateTime checkInTime = LocalDateTime.now();

        if(employeeAttendanceService.isValidId(id)) {
            String message1 = employeeAttendanceService.recordCheckIn(id, checkInTime);
            if (message1.contains("t")) {
                return ResponseEntity.ok("Checked in successfully.");
            }else{
                return ResponseEntity.ok("You can't enter Now");
            }
        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid ID.");
        }
    }

    @PostMapping("/check-out/{id}")
    public ResponseEntity<String> checkOut(@PathVariable String id) {
        // Get the current timestamp
        LocalDateTime checkOutTime = LocalDateTime.now();

        if(employeeAttendanceService.isValidIdCheckout(id)) {

            String message = employeeAttendanceService.recordCheckOut(id, checkOutTime);

            if (message.contains("you can exit now -->")) {
                return ResponseEntity.ok("Checked out successfully: " + message);
            }else if(message.contains("you don't have arrived at morning-->")){
                return ResponseEntity.ok("you haven't checked in at morning" + message);
            }else{
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("you can't leave NOW");
            }

        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Your ID is not recorded when checking in.");
        }
    }
}