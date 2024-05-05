package com.example.CompanyB.HumanResourceManagementModule.Controller;

import com.example.CompanyB.HumanResourceManagementModule.Model.Administrator;
import com.example.CompanyB.HumanResourceManagementModule.Model.Employee;
import com.example.CompanyB.HumanResourceManagementModule.Service.AdministratorService;
import com.example.CompanyB.HumanResourceManagementModule.Service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class AdministratorControllerTest {

    @Mock
    private AdministratorService administratorService;

    @Mock
    private EmployeeService employeeService;

    @InjectMocks
    private AdministratorController administratorController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createAdministrator() {
        // Given
        Administrator administrator = new Administrator();
        administrator.setUserId("admin123");

        doNothing().when(administratorService).createAdministrator(any());
        ResponseEntity<String> response = administratorController.createAdministrator(administrator);
        assertEquals("Administrator created successfully.", response.getBody());
    }


    @Test
    void getAllAdmin() {
        // Given
        List<Administrator> administrators = new ArrayList<>();
        administrators.add(new Administrator());
        administrators.add(new Administrator());

        when(administratorService.getAllAdmin()).thenReturn(administrators);
        ResponseEntity<List<Administrator>> response = administratorController.getAllAdmin();

        assertFalse(response.getBody().isEmpty());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void testCreateAdministrator() {
        // Given
        String employeeId = "emp123";
        Employee employee = new Employee();
        employee.setUserId(employeeId);

        when(employeeService.getEmployeeById(employeeId)).thenReturn(employee);
        doNothing().when(administratorService).createAdministrator(any());
        ResponseEntity<String> response = administratorController.createAdministrator(employeeId);

        assertEquals("Administrator created successfully.", response.getBody());
    }

    @Test
    void deleteAdministrator() {
        // Given
        String adminId = "admin123";

        when(administratorService.deleteAdministrator(adminId)).thenReturn(true);
        ResponseEntity<String> response = administratorController.deleteAdministrator(adminId);

        assertEquals("Administrator with ID " + adminId + " has been successfully deleted.", response.getBody());
    }

    @Test
    void getPermission() {
        // Given
        String id = "emp123";

        when(administratorService.getPermission(id)).thenReturn(true);
        String response = administratorController.getPermission(id);

        assertEquals("Short leave permission granted for id:" + id, response);
    }
}