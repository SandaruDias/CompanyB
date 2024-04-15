package com.example.CompanyB.HumanResourceManagementModule.Service;

import com.example.CompanyB.HumanResourceManagementModule.Model.Employ;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployRepo;
import com.example.CompanyB.HumanResourceManagementModule.Repository.searchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployService {

    @Autowired
    private EmployRepo employRepo;

    @Autowired
    private searchRepository searchRepo;

    public void createEmploy(Employ employ){
        employRepo.save(employ);
    }

    public List<Employ> getAllEmploy(){
        return employRepo.findAll();
    }

    public List<Employ> getEmployByName(String name){
        return searchRepo.findByText(name);
    }
}
