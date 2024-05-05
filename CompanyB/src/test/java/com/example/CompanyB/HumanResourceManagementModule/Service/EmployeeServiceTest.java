package com.example.CompanyB.HumanResourceManagementModule.Service;

import com.example.CompanyB.HumanResourceManagementModule.Model.Employee;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepo employeeRepo;

    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEmpDivision_WhenEmployeeExists() {
        // Given
        String id = "EMP01";
        Employee employee = new Employee();
        employee.setDivision("HR");


        when(employeeRepo.findById(id)).thenReturn(Optional.of(employee));
        String division = employeeService.getEmpDivision(id);
        assertEquals("HR", division);
    }

    @Test
    void getEmpDivision_WhenEmployeeDoesNotExist() {
        // Given
        String id = "EMP02";

        when(employeeRepo.findById(id)).thenReturn(Optional.empty());
        String division = employeeService.getEmpDivision(id);
        assertEquals("Enter correct id", division);
    }

    @Test
    void updateEmployeeSalaryInfo() {
        // Given
        String id = "EMP01";
        Employee existingEmployee = new Employee();
        existingEmployee.setSalary(5000);

        Employee updatedEmployee = new Employee();
        updatedEmployee.setSalary(6000);

        when(employeeRepo.findById(id)).thenReturn(Optional.of(existingEmployee));
        boolean updated = employeeService.updateEmployeeSalaryInfo(id, updatedEmployee);

        assertTrue(updated);
        assertEquals(6000, existingEmployee.getSalary());
    }

    @Test
    void deleteEmployeeById_WhenEmployeeExists() {
        // Given
        String id = "EMP01";

        when(employeeRepo.findById(id)).thenReturn(Optional.of(new Employee()));
        boolean deleted = employeeService.deleteEmployeeById(id);

        assertTrue(deleted);
        verify(employeeRepo, times(1)).deleteById(id);
    }

    @Test
    void deleteEmployeeById_WhenEmployeeDoesNotExist() {
        // Given
        String id = "EMP02";

        when(employeeRepo.findById(id)).thenReturn(Optional.empty());
        boolean deleted = employeeService.deleteEmployeeById(id);

        assertFalse(deleted);
        verify(employeeRepo, never()).deleteById(id);
    }

    @Test
    void getCourseLevelById_WhenEmployeeExists() {
        // Given
        String id = "EMP01";
        Employee employee = new Employee();
        employee.setCourseLevel("3");

        when(employeeRepo.findById(id)).thenReturn(Optional.of(employee));
        String courseLevel = employeeService.getCourseLevelById(id);
        assertEquals("3", courseLevel);
    }

    @Test
    void getCourseLevelById_WhenEmployeeDoesNotExist() {
        // Given
        String id = "EMP02";

        when(employeeRepo.findById(id)).thenReturn(Optional.empty());
        String courseLevel = employeeService.getCourseLevelById(id);
        assertEquals("Employee not found", courseLevel);
    }

    @Test
    void updateEmployeeCourseLevel_WhenEmployeeExists() {
        // Given
        String id = "EMP01";
        String newLevel = "4";
        Employee existingEmployee = new Employee();

        when(employeeRepo.findById(id)).thenReturn(Optional.of(existingEmployee));
        boolean updated = employeeService.updateEmployeeCourseLevel(id, newLevel);

        assertTrue(updated);
        assertEquals("4", existingEmployee.getCourseLevel());
    }

    @Test
    void updateEmployeeCourseLevel_WhenEmployeeDoesNotExist() {
        // Given
        String id = "EMP02";
        String newLevel = "4";

        when(employeeRepo.findById(id)).thenReturn(Optional.empty());
        boolean updated = employeeService.updateEmployeeCourseLevel(id, newLevel);

        assertFalse(updated);
    }

    @Test
    void getEmployeeById_WhenEmployeeExists() {
        // Given
        String id = "EMP01";
        Employee employee = new Employee();
        employee.setUserId(id);

        when(employeeRepo.findById(id)).thenReturn(Optional.of(employee));
        Employee result = employeeService.getEmployeeById(id);

        assertNotNull(result);
        assertEquals(id, result.getUserId());
    }

    @Test
    void getEmployeeById_WhenEmployeeDoesNotExist() {
        // Given
        String id = "EMP02";
        when(employeeRepo.findById(id)).thenReturn(Optional.empty());
        Employee result = employeeService.getEmployeeById(id);

        assertNull(result);
    }
}