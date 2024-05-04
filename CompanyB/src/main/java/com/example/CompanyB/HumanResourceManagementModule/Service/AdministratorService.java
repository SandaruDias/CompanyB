package com.example.CompanyB.HumanResourceManagementModule.Service;

import com.example.CompanyB.HumanResourceManagementModule.Model.Administrator;
import com.example.CompanyB.HumanResourceManagementModule.Model.Employee;
import com.example.CompanyB.HumanResourceManagementModule.Model.EmployeeAttendanceModel;
import com.example.CompanyB.HumanResourceManagementModule.Repository.AdministratorRepo;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployeeAttendanceRepo;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepo administratorRepo;

    @Autowired
    private EmployeeAttendanceRepo employeeAttendanceRepo;

    // Method to retrieve an administrator by ID
    public Administrator getAdministratorById(String id) {
        return administratorRepo.findById(id).orElse(null);
    }

    // Method to create a new administrator
    public void createAdministrator(Administrator administrator) {
        administratorRepo.save(administrator);
    }

    // Method to delete an administrator by ID
    public void deleteAdministrator(String id) {
        administratorRepo.deleteById(id);
    }

    // Method to retrieve all administrators
    public List<Administrator> getAllAdmin(){
        return administratorRepo.findAll();
    }

    // Method to change the password of an administrator
    public void changePassword(String id, String newPassword){
        // Find the administrator by ID and update the password
        administratorRepo.findById(id).ifPresent(administrator -> administrator.setPassword(newPassword));
    }

    // Method to grant permission for an operation (example: set short leave as "Taken")
    public boolean getPermission(String id){
        Optional<EmployeeAttendanceModel> employeeAttendanceModel = employeeAttendanceRepo.findById(id);
        if (employeeAttendanceModel.isPresent()) {
            // Set short leave status to "Taken" for the given ID
            employeeAttendanceModel.get().setShortLeave("Taken");
            return true;
        } else {
            return false; // Return false if attendance record is not found
        }
    }
}

