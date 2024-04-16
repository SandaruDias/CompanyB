package com.example.CompanyB.HumanResourceManagementModule.Controller;

import com.example.CompanyB.HumanResourceManagementModule.Model.Employ;
import com.example.CompanyB.HumanResourceManagementModule.Service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class EmployController {

    @Autowired
    private EmployService employService;

    @PostMapping("/hr/employ/createEmploy")
    public void createEmploy(@RequestBody Employ employ1){
        employService.createEmploy(employ1);
    }

    @GetMapping("/hr/employ/getAllEmploy")
    public List<Employ> getAllEmploy1(){
        return employService.getAllEmploy();
    }

    @GetMapping("/hr/employ/{name}")
    public List<Employ> findEmployByName(@PathVariable String name){
        return employService.getEmployByName(name);
    }

    @GetMapping("/hr")
    public String welcome(){
        return "--- HUMAN RESOURCE --- ";
    }

}
