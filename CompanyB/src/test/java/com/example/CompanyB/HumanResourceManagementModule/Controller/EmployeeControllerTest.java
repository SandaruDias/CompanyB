package com.example.CompanyB.HumanResourceManagementModule.Controller;

import com.example.CompanyB.HumanResourceManagementModule.Model.Employee;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployeeRepo;
import com.example.CompanyB.HumanResourceManagementModule.Service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EmployeeControllerTest {

    private Employee employee;
    private EmployeeService employeeService;
    private EmployeeRepo employeeRepo ;

    @BeforeEach
    void setup() {
        employee = new Employee();
        employee.setUserId("EMP01");
        employee.setCourseLevel("2");
        employee.setDivision("hr");
        employee.setFirstName("jason");
        employee.setEmail("test@gmail.com");

        employeeService = mock(EmployeeService.class);
        employeeRepo = mock(EmployeeRepo.class);
        employeeService.setEmployeeRepo(employeeRepo);
    }

    @Test
    void getEmployeeById() {

        when(employeeService.getEmployeeById("EMP01")).thenReturn(employee);
        Employee result = employeeService.getEmployeeById("EMP01");

        // Assertions
        assertEquals("jason", result.getFirstName());
        assertEquals("test@gmail.com", result.getEmail());
    }

    @Test
    void getEmpDivision() {
        when(employeeService.getEmpDivision("EMP01")).thenReturn("hr");
        String division = employeeService.getEmpDivision("EMP01");
        assertEquals("hr", division);
    }

    @Test
    void getPositionById() {

        when(employeeService.getCourseLevelById("EMP01")).thenReturn("2");
        when(employeeService.getEmpDivision("EMP01")).thenReturn("hr");

        String position = employeeService.getCourseLevelById("EMP01");
        String division = employeeService.getEmpDivision("EMP01");

        // Assertions
        assertEquals("2", position);
        assertEquals("hr", division);
    }
    @Test
    void updateEmployeeSalaryInfo() {
        Employee updatedEmployee = new Employee();
        updatedEmployee.setSalary(5000);
        updatedEmployee.setAllowance(500);
        updatedEmployee.setOtRate(20);
        updatedEmployee.setWorkingDays(22);

        when(employeeService.updateEmployeeSalaryInfo("EMP01", updatedEmployee)).thenReturn(true);
        boolean updated = employeeService.updateEmployeeSalaryInfo("EMP01", updatedEmployee);
        assertEquals(true, updated);
    }

    @Test
    void deleteEmployeeById() {

        when(employeeService.deleteEmployeeById("EMP01")).thenReturn(true);
        boolean deleted = employeeService.deleteEmployeeById("EMP01");
        assertEquals(true, deleted);
    }

    @Test
    void updateEmployeeCourseLevel() {
        String newLevel = "3";
        when(employeeService.updateEmployeeCourseLevel("EMP01", newLevel)).thenReturn(true);
        boolean updated = employeeService.updateEmployeeCourseLevel("EMP01", newLevel);
        assertEquals(true, updated);
    }

}