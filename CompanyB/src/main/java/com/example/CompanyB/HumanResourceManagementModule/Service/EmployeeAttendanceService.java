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


    // check if the id is valid or not for attendance tracking when check in
    // will look in the employee database
    public boolean isValidId(String id) {

        // Check if the ID exists in the database
        Optional<Employee> employeeAttendance = employeeRepo.findById(id);
        return employeeAttendance.isPresent();
    }




    // check if the id is valid or not when checking out
    public boolean isValidIdCheckout(String id) {

        // Check if the ID exists in the database employeeAttendancedb
        Optional<EmployeeAttendanceModel> employeeAttendanceCheckout = employeeAttendanceRepo.findById(id);
        return employeeAttendanceCheckout.isPresent();
    }




    // check if the checked in time is valid or not for attendance.
    public boolean isValidCheckInTime(LocalDateTime checkInTime) {

        // Define the start and end times of the time range
        LocalTime startTime = LocalTime.of(7, 45); // 7:45 AM
        LocalTime endTime = LocalTime.of(8, 15); // 8:15 AM

        // Extract the time part from LocalDateTime
        LocalTime checkInLocalTime = checkInTime.toLocalTime();

        // Check if the check-in time falls within the specified range
        return checkInLocalTime.isAfter(startTime) && checkInLocalTime.isBefore(endTime);
    }




    // check if the checked out time is valid or not for attendance based on the short leaves taken or not
    // if a short leave is taken the employee can leave that day early on the specified time or after any time
    // if not employee has to wait till the end of the working time or after.
    public boolean isValidCheckOutTime(LocalDateTime checkOutTime, String id) {

        // hold all the employees' ids that have access to have a short lave.
        ArrayList<String> shortLeaves = new ArrayList<>();

        // get all the employees attended today to a list.
        List<EmployeeAttendanceModel> employees = employeeAttendanceRepo.findAll();

        // checking through the list employee to see if anyone have short leaves.
        // if so we add them to the shortLeaves list.
        if (employees.isEmpty()) {
            return false;
        } else{
            for (EmployeeAttendanceModel employee : employees) {
                if(employee.getShortLeave().equals("Taken")){
                    shortLeaves.add(employee.getId());
                }
            }
        }

        // if the employee has permission for short leave, can leave early, unless can't leave early
        if (shortLeaves.contains(id)) {
            LocalTime endTime = LocalTime.of(12, 15); // short leave time is 12.15 pm
            // Check if the check-out time is after specified time
            return checkOutTime.toLocalTime().isAfter(endTime);
        } else {
            LocalTime endTime = LocalTime.of(5, 15); // 5:15 PM
            // Check if the check-out time is after specified time
            return checkOutTime.toLocalTime().isAfter(endTime);
        }
    }




    // Record attendance when an employee checks in
    public String recordCheckIn(String id, LocalDateTime checkInTime) {

        // Check if the check-in time is valid
        if (isValidCheckInTime(checkInTime)) {

            // when employees are checked in for a new day they will be saved in new database employeeAttendancedb
            EmployeeAttendanceModel employeeAttendanceModel = new EmployeeAttendanceModel();
            employeeAttendanceModel.setId(id);
            employeeAttendanceModel.setShortLeave("Not taken");

            // getting the sl time by adding 5 hours and 30 minutes
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
        if (isValidCheckOutTime(checkOutTime, id)) {

            // Retrieve the attendance record for the employee
            Optional<EmployeeAttendanceModel> optionalAttendance = employeeAttendanceRepo.findById(id);

            // Handle missing attendance record
            // this checks if the employee attended at morning
            if (optionalAttendance.isPresent()) {

                EmployeeAttendanceModel attendanceModel = optionalAttendance.get();

                LocalDateTime slCheckOutTime = checkOutTime.plusHours(5).plusMinutes(30);

                // if the check-out time is valid save it to the employeeAttendancedb.
                attendanceModel.setCheckOutTime(slCheckOutTime);

                employeeAttendanceRepo.save(attendanceModel);

                // calculating the hours worked depending on inTime and outTime.
                calculateHoursWorked(id,attendanceModel.getCheckInTime(),attendanceModel.getCheckOutTime());

                return "you can exit now -->" + id;
            } else {
                return "you don't have arrived at morning-->" + id; // this case won't happen practically mostly.
            }

        } else {
            return "Invalid check-out time!";
        }
    }




    // Calculate hours worked between check-in and check-out times
    private void calculateHoursWorked(String id,LocalDateTime InTime, LocalDateTime OutTime) {

        Optional<EmployeeAttendanceModel> employee = employeeAttendanceRepo.findById(id);

        // duration between inTime and outTime.
        Duration duration = Duration.between(InTime, OutTime);

        // Convert duration to hours
        long totalSeconds = duration.toSeconds();

        // save per day working hours in employeeAttendancedb database.
        double time =  (double) totalSeconds / 3600;
        employee.get().setHoursWorked(time);
        employeeAttendanceRepo.save(employee.get());

        // we will store the hoursWorked for each employee in separate database totalHoursdb.
        incrementPerMonthHoursWorked(id,time,employee);
    }




    // cumulative calculation of working hours for each month
    private void incrementPerMonthHoursWorked(String id,double time,Optional<EmployeeAttendanceModel> attendanceModel) {

        Optional<TotalHoursWorkedModel> employeePerMonthHrs = totalHoursWorkedRepo.findById(id);

        double perMonthHoursWorked = employeePerMonthHrs.get().getPerMonthHoursWorked();

        // Get the current date and time for checking if a new month has arrived.
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Check if it's a new month
        if (currentDateTime.getMonthValue() != attendanceModel.get().getCheckOutTime().getMonthValue()) {

            // Reset perMonthHoursWorked to zero at the first day of each new month
            // but at the last day of each month total worked hours for each month already used to calculate the payroll and other stuffs
            employeePerMonthHrs.get().setPerMonthHoursWorked(0);
        }else {
            // Increment perMonthHoursWorked cumulatively if it is not a new month in the totalHoursdb database.
            perMonthHoursWorked += time;
            employeePerMonthHrs.get().setPerMonthHoursWorked(perMonthHoursWorked);
            totalHoursWorkedRepo.save(employeePerMonthHrs.get());
        }
    }
}

