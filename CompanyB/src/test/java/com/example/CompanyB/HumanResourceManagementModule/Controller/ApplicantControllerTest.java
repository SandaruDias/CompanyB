package com.example.CompanyB.HumanResourceManagementModule.Controller;

import com.example.CompanyB.HumanResourceManagementModule.Model.Applicant;
import com.example.CompanyB.HumanResourceManagementModule.Service.ApplicantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ApplicantControllerTest {

    @Mock
    private ApplicantService applicantService;

    @InjectMocks
    private ApplicantController applicantController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addApplicant() {
        // Given
        Applicant applicant = new Applicant();
        applicant.setNic("NIC123");
        applicant.setEducation("Bachelor's Degree");
        applicant.setAbout("Experienced professional seeking new opportunities");

        doNothing().when(applicantService).addApplication(applicant);
        ResponseEntity<String> responseEntity = applicantController.addApplicant(applicant);
        verify(applicantService, times(1)).addApplication(applicant);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Applicant added successfully.", responseEntity.getBody());
    }

    @Test
    void getAllApplications() {
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

        when(applicantService.getAllApplication()).thenReturn(applicants);
        ResponseEntity<List<Applicant>> responseEntity = applicantController.getAllApplications();
        verify(applicantService, times(1)).getAllApplication();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(applicants.size(), responseEntity.getBody().size());
        assertEquals(applicants, responseEntity.getBody());
    }
}