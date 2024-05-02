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

    public Administrator getAdministratorById(String id) {
        return administratorRepo.findById(id).orElse(null);
    }

    public void createAdministrator(Administrator administrator) {
        administratorRepo.save(administrator);
    }

    public void deleteAdministrator(String id) {
        administratorRepo.deleteById(id);
    }
    public List<Administrator> getAllAdmin(){
        return administratorRepo.findAll();
    }

    public void changePassword(String id,String newPassword){
        administratorRepo.findById(id).get().setPassword(newPassword);
    }
    public boolean getPermission(String id){
        Optional<EmployeeAttendanceModel> employeeAttendanceModel = employeeAttendanceRepo.findById(id);
        employeeAttendanceModel.get().setShortLeave("Taken");
        return true;
    }

}
