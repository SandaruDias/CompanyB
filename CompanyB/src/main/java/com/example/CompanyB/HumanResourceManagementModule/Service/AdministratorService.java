package com.example.CompanyB.HumanResourceManagementModule.Service;

import com.example.CompanyB.HumanResourceManagementModule.Model.Administrator;
import com.example.CompanyB.HumanResourceManagementModule.Model.EmployeeAttendanceModel;
import com.example.CompanyB.HumanResourceManagementModule.Repository.AdministratorRepo;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployeeAttendanceRepo;
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

    //  to retrieve an administrator by ID
    public Administrator getAdministratorById(String id) {
        return administratorRepo.findById(id).orElse(null);
    }

    //  to create a new administrator
    public void createAdministrator(Administrator administrator) {
        administratorRepo.save(administrator);
    }

    //  to delete an administrator by ID
    public boolean deleteAdministrator(String id) {
        if(administratorRepo.findById(id).isPresent()){
            administratorRepo.deleteById(id);
            return true;
        }

        return false;
    }

    //  to retrieve all administrators
    public List<Administrator> getAllAdmin(){
        return administratorRepo.findAll();
    }

    //  to change the password of an administrator
    public void changePassword(String id, String newPassword){
        // Find the administrator by ID and update the password
        administratorRepo.findById(id).ifPresent(administrator -> administrator.setPassword(newPassword));
    }

    // granting permission for short leaves
    // but for this the employee has to check in the morning and ask for the permission from HR admin.
    public boolean getPermission(String id){
        Optional<EmployeeAttendanceModel> employeeAttendanceModel = employeeAttendanceRepo.findById(id);
        if (employeeAttendanceModel.isPresent()) {
            employeeAttendanceModel.get().setShortLeave("Taken");
            employeeAttendanceRepo.save(employeeAttendanceModel.get());
            return true;
        }else{
            return false;
        }
    }
}

