package com.example.CompanyB.HumanResourceManagementModule.Service;

import com.example.CompanyB.HumanResourceManagementModule.Model.Applicant;
import com.example.CompanyB.HumanResourceManagementModule.Repository.ApplicantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepo applicantRepo;

    public void addApplication(Applicant applicant){
        applicantRepo.save(applicant);
    }

    public List<Applicant> getAllApplication(){
        return applicantRepo.findAll();
    }

}
