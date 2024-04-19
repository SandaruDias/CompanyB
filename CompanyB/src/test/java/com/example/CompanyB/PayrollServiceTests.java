package com.example.CompanyB;

import com.example.CompanyB.FinancePayRollModule.Model.Payroll;
import com.example.CompanyB.FinancePayRollModule.Repository.PayrollRepository;
import com.example.CompanyB.FinancePayRollModule.Service.PayrollService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PayrollServiceTests {

    @MockBean
    private PayrollRepository payrollRepository;

    @InjectMocks
    private PayrollService payrollService;

    @Test
    public void testCalculateAndSavePayroll() {
        // Given
        Payroll payroll = new Payroll();
        payroll.setEmployeeId(1L);
        payroll.setGrossSalary(5000.00);
        payroll.setNetSalary(4500.00);
        payroll.setTaxDeductions(500.00);

        given(payrollRepository.save(any(Payroll.class))).willReturn(payroll);

        // When
        Payroll savedPayroll = payrollService.calculateAndSavePayroll(1L, 160.0, 25.0, 20.0, 30.0, 500.00);

        // Then
        assertThat(savedPayroll.getNetSalary()).isEqualTo(4500.00);
        verify(payrollRepository).save(any(Payroll.class));
    }
}
