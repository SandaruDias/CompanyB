package com.example.CompanyB.HumanResourceManagementModule.Controller;

import com.example.CompanyB.HumanResourceManagementModule.Model.Applicant;
import com.example.CompanyB.HumanResourceManagementModule.Service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hr/applicant")
public class ApplicantController {

    @Autowired
    private ApplicantService applicantService;

    // Endpoint to add a new applicant
    @PostMapping("/add")
    public ResponseEntity<Void> addApplicant(@RequestBody Applicant applicant) {
        applicantService.addApplication(applicant);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Endpoint to retrieve all applications
    @GetMapping("/getAll")
    public ResponseEntity<List<Applicant>> getAllApplications() {
        List<Applicant> applications = applicantService.getAllApplication();
        return ResponseEntity.ok(applications);
    }

}
