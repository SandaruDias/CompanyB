package com.example.CompanyB.HumanResourceManagementModule.Controller;

import com.example.CompanyB.HumanResourceManagementModule.Model.Applicant;
import com.example.CompanyB.HumanResourceManagementModule.Service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    @PostMapping("/hr/applicant/addApplication")
    public void createEmploy(@RequestBody Applicant applicant){
        applicantService.addApplication(applicant);

    }

    @GetMapping("/hr/applicant/getAllApplication")
    public List<Applicant> getAllApplication1(){
        return applicantService.getAllApplication();
    }

    @GetMapping("/hr/applicant/{text}")
    public List<Applicant> findApplicantByKeyword(@PathVariable String text){
        return applicantService.findApplicationByText(text);
    }
}
