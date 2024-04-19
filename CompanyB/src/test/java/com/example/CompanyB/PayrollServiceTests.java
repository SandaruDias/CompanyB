package com.example.CompanyB;

import com.example.CompanyB.FinancePayRollModule.Model.Payroll;
import com.example.CompanyB.FinancePayRollModule.Repository.PayrollRepository;
import com.example.CompanyB.FinancePayRollModule.Service.PayrollService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PayrollServiceTests {

    @Mock
    private PayrollRepository payrollRepository;

    @Mock
    private WebClient.Builder webClientBuilder;

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestHeadersUriSpec requestHeadersUriSpec;

    @Mock
    private WebClient.RequestHeadersSpec requestHeadersSpec;

    @InjectMocks
    private PayrollService payrollService;

    @BeforeEach
    void setUp() {
        // Set up WebClient Mock
        when(webClientBuilder.baseUrl(anyString())).thenReturn(webClientBuilder);
        when(webClientBuilder.build()).thenReturn(webClient);
        when(webClient.post()).thenReturn((WebClient.RequestBodyUriSpec) requestHeadersUriSpec);
        when(requestHeadersUriSpec.uri(anyString())).thenReturn(requestHeadersSpec);
        when(requestHeadersSpec.retrieve()).thenReturn(null); // Mock further as necessary
    }

    @Test
    void testCalculateAndSavePayroll() {
        // Arrange
        Payroll payroll = new Payroll();
        payroll.setEmployeeId(1L);
        payroll.setPayPeriodStart(new Date());
        payroll.setPayPeriodEnd(new Date());
        payroll.setGrossSalary(10000.00);
        payroll.setNetSalary(8000.00);
        payroll.setTaxDeductions(2000.00);
        payroll.setPayDate(new Date());
        payroll.setStatus("Processed");

        when(payrollRepository.save(any(Payroll.class))).thenReturn(payroll);

        // Act
        Payroll savedPayroll = payrollService.calculateAndSavePayroll(1L, 160.0, 25.0, 20.0, 30.0, 2000.00);

        // Assert
        verify(payrollRepository).save(any(Payroll.class));
        assert savedPayroll.getNetSalary().equals(8000.00);
    }
}
