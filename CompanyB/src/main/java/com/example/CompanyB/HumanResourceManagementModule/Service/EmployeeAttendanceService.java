package com.example.CompanyB.HumanResourceManagementModule.Service;

import com.example.CompanyB.HumanResourceManagementModule.Model.Employee;
import com.example.CompanyB.HumanResourceManagementModule.Model.EmployeeAttendanceModel;
import com.example.CompanyB.HumanResourceManagementModule.Model.TotalHoursWorkedModel;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployeeAttendanceRepo;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployeeRepo;
import com.example.CompanyB.HumanResourceManagementModule.Repository.TotalHoursWorkedRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeAttendanceService {

    private EmployeeAttendanceRepo employeeAttendanceRepo;
    private EmployeeRepo employeeRepo;
    private TotalHoursWorkedRepo totalHoursWorkedRepo;
    private AdministratorService administratorService;


    // check if the id is valid or not for attendance tracking.
    public boolean isValidId(String id) {
        // Check if the ID exists in the database
        Optional<Employee> employeeAttendance = employeeRepo.findById(id);
        return employeeAttendance.isPresent();
    }

    // check if the id is valid or not when checking out
    public boolean isValidIdCheckout(String id) {
        // Check if the ID exists in the database employee attendance db
        Optional<EmployeeAttendanceModel> employeeAttendanceCheckout = employeeAttendanceRepo.findById(id);
        return employeeAttendanceCheckout.isPresent();
    }

    // check if the checked in time is valid or not for attendance.
    public boolean isValidCheckInTime(LocalDateTime checkInTime) {
        // Define the start and end times of the time range
        LocalTime startTime = LocalTime.of(14, 20); // 7:45 AM
        LocalTime endTime = LocalTime.of(17, 54); // 8:15 AM

        // Extract the time part from LocalDateTime
        LocalTime checkInLocalTime = checkInTime.toLocalTime();

        // Check if the check-in time falls within the specified range
        return checkInLocalTime.isAfter(startTime) && checkInLocalTime.isBefore(endTime);
    }



    // check if the checked out time is valid or not for attendance.
    public boolean isValidCheckOutTime(LocalDateTime checkOutTime) {
        // Define the end time of the time range
        ArrayList<String> shortLeaves = new ArrayList<>();
        List<EmployeeAttendanceModel> employees = employeeAttendanceRepo.findAll();
        if (employees.isEmpty()) {
            return false;
        }
        else{
            for (EmployeeAttendanceModel employee : employees) {
                if(employee.getShortLeave().equals("Taken")){
                    shortLeaves.add(employee.getId());
                }
            }
        }

        for (String shortLeave : shortLeaves) {
            if (administratorService.getPermission(shortLeave)) {
                LocalTime endTime = LocalTime.of(16, 19);
                return checkOutTime.toLocalTime().isAfter(endTime);
            } else {
                LocalTime endTime = LocalTime.of(20, 45); // 4:45 PM
                // Check if the check-out time is after 4:45 PM
                return checkOutTime.toLocalTime().isAfter(endTime);
            }
        }
        return false;
    }


    // Record attendance when an employee checks in
    public String recordCheckIn(String id, LocalDateTime checkInTime) {

        // Check if the check-in time is valid
        if (isValidCheckInTime(checkInTime)) {

            // Create a new EmployeeAttendanceModel instance

            EmployeeAttendanceModel employeeAttendanceModel = new EmployeeAttendanceModel();
            employeeAttendanceModel.setId(id);
            employeeAttendanceModel.setShortLeave("Not taken");

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
            System.out.println(optionalAttendance);

            // Handle missing attendance record
            if (optionalAttendance.isPresent()) {

                EmployeeAttendanceModel attendanceModel = optionalAttendance.get();

                LocalDateTime slCheckOutTime = checkOutTime.plusHours(5).plusMinutes(30);
                attendanceModel.setCheckOutTime(slCheckOutTime);
                employeeAttendanceRepo.save(attendanceModel);

                calculateHoursWorked(id,attendanceModel.getCheckInTime(),attendanceModel.getCheckOutTime());
                // extracting the perMonthHoursWorked into another database

//                return "you can exit now-->" + id;
                return "you can exit now--> check in time" + attendanceModel.getCheckInTime() + "  check out time" + attendanceModel.getCheckOutTime();
            } else {
                return "you don't have arrived at morning-->" + id; // this case won't happen usually.
            }
        } else {
            return "Invalid check-out time!";
        }
    }

    ArrayList<Long> hours;
    // Calculate hours worked between check-in and check-out times
    private void calculateHoursWorked(String id,LocalDateTime InTime, LocalDateTime OutTime) {
        Duration duration = Duration.between(InTime, OutTime);
        Optional<EmployeeAttendanceModel> employee = employeeAttendanceRepo.findById(id);
        // Convert duration to hours
        long totalSeconds = duration.toSeconds();
        System.out.println(totalSeconds);
        hours.add(totalSeconds);
        // Convert total minutes to decimal hours
        incrementPerMonthHoursWorked(id,hours,employee);
        double time =  (double) totalSeconds / 3600;
        employee.get().setHoursWorked(time);
        employeeAttendanceRepo.save(employee.get());
    }



    // cumulative calculation of working hours
    private void incrementPerMonthHoursWorked(String id,ArrayList<Long> hours,Optional<EmployeeAttendanceModel> attendanceModel) {
        double totalHours = 0;
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();
        // Check if it's a new month
        if (currentDateTime.getMonthValue() != attendanceModel.get().getCheckOutTime().getMonthValue()) {
            // Reset perMonthHoursWorked to zero
            attendanceModel.get().setPerMonthHoursWorked(0);
            hours.clear();
        }else {
            // Increment perMonthHoursWorked cumulatively
            for(Long hour:hours){
                totalHours += (double) hour/3600;
            }
            attendanceModel.get().setPerMonthHoursWorked(totalHours);
            employeeAttendanceRepo.save(attendanceModel.get());

            Optional<TotalHoursWorkedModel> total = totalHoursWorkedRepo.findById(id);
            total.get().setPerMonthHoursWorked(totalHours);
            totalHoursWorkedRepo.save(total.get());
            System.out.println(total);
        }
    }
}

