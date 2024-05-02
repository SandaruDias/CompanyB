package com.example.CompanyB.HumanResourceManagementModule.Service;

import com.example.CompanyB.HumanResourceManagementModule.Model.Administrator;
import com.example.CompanyB.HumanResourceManagementModule.Model.Employee;
import com.example.CompanyB.HumanResourceManagementModule.Repository.AdministratorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministratorService {

    @Autowired
    private AdministratorRepo administratorRepo;

    public Administrator getAdministratorById(String id) {
        return administratorRepo.findById(id).orElse(null);
    }

    public void createAdministrator(Administrator administrator) {
        administratorRepo.save(administrator);
    }

    public void deleteAdministrator(String id) {
        if (administratorRepo.existsById(id)) {
            administratorRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("Invalid ID: " + id);
        }
    }
    public List<Administrator> getAllAdmin(){
        return administratorRepo.findAll();
    }

    public void changePassword(String id,String newPassword){
        administratorRepo.findById(id).get().setPassword(newPassword);
    }

}
