package com.example.CompanyB.HumanResourceManagementModule.Service;

import com.example.CompanyB.HumanResourceManagementModule.Model.Employee;
import com.example.CompanyB.HumanResourceManagementModule.Model.EmployeeAttendanceModel;
import com.example.CompanyB.HumanResourceManagementModule.Model.TotalHoursWorkedModel;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployeeAttendanceRepo;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployeeRepo;
import com.example.CompanyB.HumanResourceManagementModule.Repository.TotalHoursWorkedRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeAttendanceService {

    private EmployeeAttendanceRepo employeeAttendanceRepo;
    private EmployeeRepo employeeRepo;
    private TotalHoursWorkedRepo totalHoursWorkedRepo;

    // check if the id is valid or not for attendance tracking.
    public boolean isValidId(String id) {
        // Check if the ID exists in the database
        Optional<Employee> employeeAttendance = employeeRepo.findById(id);
        if (employeeAttendance.isPresent()) {
            return true;
        }
        return false;
    }

    // check if the id is valid or not when cheking out
    public boolean isValidIdCheckout(String id) {
        // Check if the ID exists in the database employee attendance db
        Optional<EmployeeAttendanceModel> employeeAttendanceCheckout = employeeAttendanceRepo.findById(id);
        if (employeeAttendanceCheckout.isPresent()) {
            return true;
        }
        return false;
    }

    // check if the checked in time is valid or not for attendance.
    public boolean isValidCheckInTime(LocalDateTime checkInTime) {
        // Define the start and end times of the time range
        LocalTime startTime = LocalTime.of(6, 15); // 7:45 AM
        LocalTime endTime = LocalTime.of(8, 45); // 8:15 AM

        // Extract the time part from LocalDateTime
        LocalTime checkInLocalTime = checkInTime.toLocalTime();

        // Check if the check-in time falls within the specified range
        return checkInLocalTime.isAfter(startTime) && checkInLocalTime.isBefore(endTime);
    }



    // check if the checked out time is valid or not for attendance.
    public boolean isValidCheckOutTime(LocalDateTime checkOutTime) {
        // Define the end time of the time range
        LocalTime endTime = LocalTime.of(11, 45); // 4:45 PM

        // Check if the check-out time is after 4:45 PM
        return checkOutTime.toLocalTime().isAfter(endTime);
    }


    // Record attendance when an employee checks in
    public String recordCheckIn(String id, LocalDateTime checkInTime) {

        // Check if the check-in time is valid
        if (isValidCheckInTime(checkInTime)) {

            // Create a new EmployeeAttendanceModel instance

            EmployeeAttendanceModel employeeAttendanceModel = new EmployeeAttendanceModel();
            employeeAttendanceModel.setId(id);

            LocalDateTime slCheckInTime = checkInTime.plusHours(5).plusMinutes(30);
            employeeAttendanceModel.setCheckInTime(slCheckInTime);

            // Save the attendance record to the database
            employeeAttendanceRepo.save(employeeAttendanceModel);
            return ("t");
        }else{
            return ("f");
        }
    }


    // Record attendance when an employee checks out
    public String recordCheckOut(String id, LocalDateTime checkOutTime) {

        // Check if the check-out time is valid
        if (isValidCheckOutTime(checkOutTime)) {

            // Retrieve the attendance record for the employee
            Optional<EmployeeAttendanceModel> optionalAttendance = employeeAttendanceRepo.findById(id);

            // Handle missing attendance record
            if (optionalAttendance.isPresent()) {

                EmployeeAttendanceModel attendanceModel = optionalAttendance.get();

                LocalDateTime slCheckOutTime = checkOutTime.plusHours(5).plusMinutes(30);
                attendanceModel.setCheckOutTime(slCheckOutTime);
                employeeAttendanceRepo.save(attendanceModel);

                // Calculate hours worked
                double hoursWorked = calculateHoursWorked(attendanceModel.getCheckInTime(), attendanceModel.getCheckOutTime());

                // this will updated daily will hold the value untill the hoursworked is added to permonthHourseWorked.
                attendanceModel.setHoursWorked(hoursWorked);
                employeeAttendanceRepo.save(attendanceModel);

                // Increment perMonthAttendance and totalAttendance
                // use this to calculate the payroll
                incrementPerMonthHoursWorked(attendanceModel);

                // Update the attendance record in the database
                employeeAttendanceRepo.save(attendanceModel);

                // extracting the perMonthHoursWorked into another database
                TotalHoursWorkedModel totalHoursWorkedModel = new TotalHoursWorkedModel();
                totalHoursWorkedModel.setId(id);
                totalHoursWorkedModel.setPerMonthHoursWorked(attendanceModel.getPerMonthHoursWorked());

                // Save the attendance record to the database
                totalHoursWorkedRepo.save(totalHoursWorkedModel);

//                return "you can exit now-->" + id;
                return "you can exit now--> check in time" + attendanceModel.getCheckInTime() + "  check out time" + attendanceModel.getCheckOutTime();
            } else {
                return "you don't have arrived at morning-->" + id; // this case won't happen usually.
            }
        } else {
            return "Invalid check-out time!";
        }
    }


    // Calculate hours worked between check-in and check-out times
    private double calculateHoursWorked(LocalDateTime InTime, LocalDateTime OutTime) {
        // Calculate the duration between check-in and check-out times
        Duration duration = Duration.between(InTime, OutTime);

        // Convert duration minuites
        long totalMinutes = duration.toMinutes();

        // decimal hours
        double decimalHours = (double) totalMinutes / 60;

        // Return the calculated hours worked.
        return decimalHours;
    }


    // cumulative calculation of working hours
    private void incrementPerMonthHoursWorked(EmployeeAttendanceModel attendanceModel) {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Check if it's a new month
        if (currentDateTime.getMonthValue() != attendanceModel.getCheckOutTime().getMonthValue()) {
            // Reset perMonthHoursWorked to zero
            attendanceModel.setPerMonthHoursWorked(0);
        }else {
            // Increment perMonthHoursWorked cumulatively
            attendanceModel.setPerMonthHoursWorked(attendanceModel.getPerMonthHoursWorked() + attendanceModel.getHoursWorked());
        }
    }
}

