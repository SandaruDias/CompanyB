package com.example.CompanyB.HumanResourceManagementModule.Service;

import com.example.CompanyB.HumanResourceManagementModule.Model.Applicant;
import com.example.CompanyB.HumanResourceManagementModule.Repository.ApplicantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepo applicantRepo;

    // Method to add a new application
    public void addApplication(Applicant applicant){
        applicantRepo.save(applicant);
    }

    // Method to retrieve all applications
    public List<Applicant> getAllApplication(){
        return applicantRepo.findAll();
    }

    public void deleteApplicantById(String id) {
        Optional<Applicant> applicantOptional = applicantRepo.findById(id);
        if (applicantOptional.isPresent()) {
            applicantRepo.deleteById(id);
        } else {
            throw new IllegalArgumentException("Invalid ID: " + id);
        }
    }

}
