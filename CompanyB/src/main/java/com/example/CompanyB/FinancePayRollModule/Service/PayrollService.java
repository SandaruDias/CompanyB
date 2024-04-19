package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.Payroll;
import com.example.CompanyB.FinancePayRollModule.Repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Date;

@Service
public class PayrollService {
    private final PayrollRepository payrollRepository;
    private final WebClient webClient;

    @Autowired
    public PayrollService(PayrollRepository payrollRepository, WebClient.Builder webClientBuilder) {
        this.payrollRepository = payrollRepository;
        this.webClient = webClientBuilder.baseUrl("http://hrsystem.com/api").build();
    }

    public Payroll calculateAndSavePayroll(Long employeeId, Double hoursWorked, Double hourlyRate, Double overtimeHours, Double overtimeRate, Double deductions) {
        Double grossSalary = (hoursWorked * hourlyRate) + (overtimeHours * overtimeRate);
        Double taxDeductions = deductions; // Example calculation, adjust as necessary
        Double netSalary = grossSalary - taxDeductions;

        Payroll payroll = new Payroll();
        payroll.setEmployeeId(employeeId);
        payroll.setGrossSalary(grossSalary);
        payroll.setNetSalary(netSalary);
        payroll.setTaxDeductions(taxDeductions);
        payroll.setPayDate(new Date()); // Assuming pay date is today
        payroll.setStatus("Processed");

        payrollRepository.save(payroll);
        sendPayrollReportToHRSystem(payroll);
        return payroll;
    }

    private void sendPayrollReportToHRSystem(Payroll payroll) {
        webClient.post()
                .uri("/payroll-report")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(payroll)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(response -> System.out.println("Report sent successfully: " + response));
    }
}