package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.Payroll;
import com.example.CompanyB.FinancePayRollModule.Repository.PayrollRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
public class PayrollService {
    private final PayrollRepository payrollRepository;
    private final WebClient webClient;

    @Autowired
    public PayrollService(PayrollRepository payrollRepository, WebClient.Builder webClientBuilder) {
        this.payrollRepository = payrollRepository;
        this.webClient = webClientBuilder.baseUrl("http://hrsystem.com/api").build();
    }

    public Payroll calculateAndSavePayroll(Long employeeId, String employeeName, Double hoursWorked, Double hourlyRate, Double overtimeHours, Double overtimeRate, Double deductions, Double taxRate) {
        Double grossSalary = (hoursWorked * hourlyRate) + (overtimeHours * overtimeRate);
        Double taxDeductions = grossSalary * taxRate;
        Double netSalary = grossSalary - taxDeductions - deductions;

        Payroll payroll = new Payroll();
        payroll.setEmployeeId(employeeId);
        payroll.setEmployeeName(employeeName);
        payroll.setGrossSalary(grossSalary);
        payroll.setNetSalary(netSalary);
        payroll.setTaxDeductions(taxDeductions);
        payroll.setDeductions(deductions);
        payroll.setTaxRate(taxRate);
        payroll.setPayDate(new Date());
        payroll.setStatus("Processed");

        payrollRepository.save(payroll);
        sendPayrollReportToHRSystem(payroll);
        return payroll;
    }

    public void sendPayrollReportToHRSystem(Payroll payroll) {
        webClient.post()
                .uri("/payroll-report")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(payroll)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(response -> System.out.println("Report sent successfully: " + response),
                        error -> System.err.println("Error sending report: " + error.getMessage()));
    }


    public Payroll updatePayroll(String payrollId, Double deductions, Double taxRate) {
        Payroll payroll = payrollRepository.findById(payrollId).orElseThrow(() -> new RuntimeException("Payroll not found"));
        payroll.setDeductions(deductions);
        payroll.setTaxRate(taxRate);
        payroll.setTaxDeductions(payroll.getGrossSalary() * taxRate);
        payroll.setNetSalary(payroll.getGrossSalary() - payroll.getTaxDeductions() - deductions);
        return payrollRepository.save(payroll);
    }

    public byte[] generatePayrollReport(List<Payroll> payrolls) {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Payroll Report");

            // Creating header row
            Row headerRow = sheet.createRow(0);
            String[] columns = {"Employee ID", "Employee Name", "Gross Salary", "Net Salary", "Tax Deductions", "Pay Date", "Status"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);

            }

            // Filling data
            int rowNum = 1;
            for (Payroll payroll : payrolls) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(payroll.getEmployeeId());
                row.createCell(1).setCellValue(payroll.getEmployeeName());
                row.createCell(2).setCellValue(payroll.getGrossSalary());
                row.createCell(3).setCellValue(payroll.getNetSalary());
                row.createCell(4).setCellValue(payroll.getTaxDeductions());
                row.createCell(5).setCellValue(payroll.getPayDate().toString());
                row.createCell(6).setCellValue(payroll.getStatus());
            }

            // Auto-size columns
            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(bos);
            return bos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("Failed to generate payroll report", e);
        }
    }

    public Payroll findPayrollById(String payrollId) {
        return payrollRepository.findById(payrollId)
                .orElseThrow(() -> new IllegalArgumentException("Payroll not found with ID: " + payrollId));
    }

    public void deletePayrollById(String payrollId) {
        if (!payrollRepository.existsById(payrollId)) {
            throw new IllegalArgumentException("Payroll not found with ID: " + payrollId);
        }
        payrollRepository.deleteById(payrollId);
    }

    public List<Payroll> findPayrollsByEmployeeId(Long employeeId, Pageable pageable) {
        Page<Payroll> payrolls = payrollRepository.findByEmployeeId(employeeId, pageable);
        if (payrolls != null) {
            return payrolls.getContent();
        }
        return Collections.emptyList(); // Ensure it never returns null
    }

}
