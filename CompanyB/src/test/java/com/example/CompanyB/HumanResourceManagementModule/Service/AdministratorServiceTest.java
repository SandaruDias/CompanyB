package com.example.CompanyB.HumanResourceManagementModule.Service;

import com.example.CompanyB.HumanResourceManagementModule.Model.Administrator;
import com.example.CompanyB.HumanResourceManagementModule.Model.EmployeeAttendanceModel;
import com.example.CompanyB.HumanResourceManagementModule.Repository.AdministratorRepo;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployeeAttendanceRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AdministratorServiceTest {


    @Mock
    private AdministratorRepo administratorRepo;

    @Mock
    private EmployeeAttendanceRepo employeeAttendanceRepo;

    @InjectMocks
    private AdministratorService administratorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAdministratorById() {
        // Given
        String adminId = "admin123";
        Administrator administrator = new Administrator();
        administrator.setUserId(adminId);

        when(administratorRepo.findById(adminId)).thenReturn(Optional.of(administrator));
        Administrator result = administratorService.getAdministratorById(adminId);

        assertNotNull(result);
        assertEquals(adminId, result.getUserId());
    }


    @Test
    void deleteAdministrator() {
        // Given
        String adminId = "admin123";

        when(administratorRepo.findById(adminId)).thenReturn(Optional.of(new Administrator()));
        boolean result = administratorService.deleteAdministrator(adminId);

        assertTrue(result);
        verify(administratorRepo, times(1)).deleteById(adminId);
    }

    @Test
    void getAllAdmin() {
        // Given
        List<Administrator> administrators = new ArrayList<>();
        administrators.add(new Administrator());
        administrators.add(new Administrator());

        when(administratorRepo.findAll()).thenReturn(administrators);
        List<Administrator> result = administratorService.getAllAdmin();

        assertFalse(result.isEmpty());
        assertEquals(2, result.size());
    }


    @Test
    void getPermission() {
        // Given
        String attendanceId = "attendance123";
        when(employeeAttendanceRepo.findById(attendanceId)).thenReturn(Optional.of(new EmployeeAttendanceModel()));
        boolean result = administratorService.getPermission(attendanceId);

        assertTrue(result);
        verify(employeeAttendanceRepo, times(1)).save(any());
    }
}