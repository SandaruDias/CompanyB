package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.Payroll;
import com.example.CompanyB.FinancePayRollModule.Service.PayrollService;
import com.example.CompanyB.FinancePayRollModule.Repository.PayrollRepository;
import com.example.CompanyB.FinancePayRollModule.Service.dto.PayrollDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.BDDMockito.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PayrollController.class)
public class PayrollControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PayrollService payrollService;

    @MockBean
    private PayrollRepository payrollRepository;

    private PayrollDTO payrollDTO;
    private Payroll payroll;

    @BeforeEach
    void setUp() {
        payrollDTO = new PayrollDTO();
        payrollDTO.setEmployeeId(1L);
        payrollDTO.setEmployeeName("John Doe");
        payrollDTO.setHoursWorked(40.0);
        payrollDTO.setHourlyRate(20.0);
        payrollDTO.setOvertimeHours(5.0);
        payrollDTO.setOvertimeRate(30.0);
        payrollDTO.setDeductions(200.0);
        payrollDTO.setTaxRate(0.15);

        payroll = new Payroll();
        payroll.setId("1");
        payroll.setEmployeeId(1L);
        payroll.setEmployeeName("John Doe");
        payroll.setGrossSalary(1000.0);
        payroll.setNetSalary(800.0);
        payroll.setTaxRate(0.15);
    }

    @Test
    void testCalculatePayroll() throws Exception {
        given(payrollService.calculateAndSavePayroll(anyLong(), anyString(), anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyDouble(), anyDouble())).willReturn(payroll);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/payroll/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"employeeId\": 1, \"employeeName\": \"John Doe\", \"hoursWorked\": 40, \"hourlyRate\": 20, \"overtimeHours\": 5, \"overtimeRate\": 30, \"deductions\": 200, \"taxRate\": 0.15}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.employeeId").value(1))
                .andExpect(jsonPath("$.employeeName").value("John Doe"))
                .andExpect(jsonPath("$.grossSalary").value(1000.0))
                .andExpect(jsonPath("$.netSalary").value(800.0));
    }

    @Test
    void testGetPayrollById() throws Exception {
        given(payrollService.findPayrollById("1")).willReturn(payroll);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/payroll/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.employeeName").value("John Doe"));
    }

    @Test
    void testUpdatePayroll() throws Exception {
        given(payrollService.updatePayroll(ArgumentMatchers.anyString(), ArgumentMatchers.anyDouble(), ArgumentMatchers.anyDouble())).willReturn(payroll);

        mockMvc.perform(MockMvcRequestBuilders.put("/api/payroll/update/1")
                        .param("deductions", "300")
                        .param("taxRate", "0.20"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.taxRate").value(0.15));
    }

    @Test
    void testDownloadPayrollDetails() throws Exception {
        List<Payroll> payrollList = Arrays.asList(payroll);
        byte[] csvContent = "Employee ID,Employee Name,Gross Salary,Net Salary\n1,John Doe,1000.0,800.0".getBytes();
        given(payrollService.generatePayrollReport(payrollList)).willReturn(csvContent);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/payroll/download/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_OCTET_STREAM))
                .andExpect(header().string("Content-Disposition", "attachment; filename=payroll-report.csv"));
    }

    @Test
    void testDeletePayroll() throws Exception {
        willDoNothing().given(payrollService).deletePayrollById("1");

        mockMvc.perform(MockMvcRequestBuilders.delete("/api/payroll/1"))
                .andExpect(status().isNoContent());
    }
}
