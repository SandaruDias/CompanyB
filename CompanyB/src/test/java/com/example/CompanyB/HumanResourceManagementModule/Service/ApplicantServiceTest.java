package com.example.CompanyB.HumanResourceManagementModule.Service;

import com.example.CompanyB.HumanResourceManagementModule.Model.Applicant;
import com.example.CompanyB.HumanResourceManagementModule.Repository.ApplicantRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApplicantServiceTest {
    @Mock
    private ApplicantRepo applicantRepo;

    @InjectMocks
    private ApplicantService applicantService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addApplication() {
        // Given
        Applicant applicant = new Applicant();
        applicant.setNic("NIC123");
        applicant.setEducation("Bachelor's Degree");
        applicant.setAbout("Experienced professional seeking new opportunities");

        applicantService.addApplication(applicant);
        verify(applicantRepo, times(1)).save(applicant);
    }

    @Test
    void getAllApplication() {
        // Given
        Applicant applicant1 = new Applicant();
        applicant1.setNic("NIC123");
        applicant1.setEducation("Bachelor's Degree");
        applicant1.setAbout("Experienced professional seeking new opportunities");

        Applicant applicant2 = new Applicant();
        applicant2.setNic("NIC456");
        applicant2.setEducation("Master's Degree");
        applicant2.setAbout("Entry-level candidate with great potential");

        List<Applicant> applicants = new ArrayList<>();
        applicants.add(applicant1);
        applicants.add(applicant2);

        when(applicantRepo.findAll()).thenReturn(applicants);

        List<Applicant> retrievedApplicants = applicantService.getAllApplication();
        verify(applicantRepo, times(1)).findAll();
        assertEquals(applicants.size(), retrievedApplicants.size());
        assertEquals(applicants, retrievedApplicants);
    }
}