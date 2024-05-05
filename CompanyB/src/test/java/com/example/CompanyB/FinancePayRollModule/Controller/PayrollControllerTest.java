package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.EmployeePayroll;
import com.example.CompanyB.FinancePayRollModule.Service.PayrollService;
import com.example.CompanyB.FinancePayRollModule.Service.dto.PayrollDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class PayrollControllerTest {

    @Mock
    private PayrollService payrollService;

    @InjectMocks
    private PayrollController payrollController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testAddPayroll() {
        PayrollDTO payrollDTO = new PayrollDTO(); // Assume proper setters are called
        EmployeePayroll expectedPayroll = new EmployeePayroll();
        when(payrollService.createPayroll(payrollDTO)).thenReturn(expectedPayroll);

        EmployeePayroll result = payrollController.addPayroll(payrollDTO);
        assertNotNull(result);
        assertEquals(expectedPayroll, result);
    }

    @Test
    void testDeletePayroll() {
        String id = "1";
        doNothing().when(payrollService).deletePayroll(id);
        ResponseEntity<Void> response = payrollController.deletePayroll(id);

        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(payrollService, times(1)).deletePayroll(id);
    }

    @Test
    void testGetAllPayrolls() {
        List<EmployeePayroll> expectedList = new ArrayList<>();
        when(payrollService.getAllPayrollDetails()).thenReturn(expectedList);

        List<EmployeePayroll> result = payrollController.getAllPayrolls();
        assertNotNull(result);
        assertEquals(expectedList, result);
    }

    @Test
    void testGetPayrollById() {
        String id = "1";
        EmployeePayroll expectedPayroll = new EmployeePayroll();
        when(payrollService.getPayrollById(id)).thenReturn(expectedPayroll);

        EmployeePayroll result = payrollController.getPayrollById(id);
        assertNotNull(result);
        assertEquals(expectedPayroll, result);
    }

    @Test
    void testUpdatePayroll() {
        String id = "1";
        EmployeePayroll updatedPayroll = new EmployeePayroll();
        when(payrollService.updatePayroll(id, updatedPayroll)).thenReturn(updatedPayroll);

        ResponseEntity<EmployeePayroll> response = payrollController.updatePayroll(id, updatedPayroll);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedPayroll, response.getBody());
    }

    @Test
    void testGetPayrollsByEmployeeId_NotFound() {
        String employeeId = "1";
        when(payrollService.findPayrollsByEmployeeId(employeeId)).thenReturn(new ArrayList<>());

        ResponseEntity<List<EmployeePayroll>> response = payrollController.getPayrollsByEmployeeId(employeeId);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
//
//    @Test
//    void testGetPayrollsByEmployeeId_Found() {
//        String employeeId = "1";
//        List<EmployeePayroll> expectedList = new ArrayList<>();
//        when(payrollService.findPayrollsByEmployeeId(employeeId)).thenReturn(expectedList);
//
//        ResponseEntity<List<EmployeePayroll>> response = payrollController.getPayrollsByEmployeeId(employeeId);
//        assertNotNull(response);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(expectedList, response.getBody());
//    }

    @Test
    void testDownloadPayrollsByEmployeeId_IOException() throws Exception {
        String employeeId = "1";
        when(payrollService.findPayrollsByEmployeeId(employeeId)).thenReturn(new ArrayList<>());
        when(payrollService.generateExcelReport(anyList())).thenThrow(IOException.class);

        ResponseEntity<?> response = payrollController.downloadPayrollsByEmployeeId(employeeId);
        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
