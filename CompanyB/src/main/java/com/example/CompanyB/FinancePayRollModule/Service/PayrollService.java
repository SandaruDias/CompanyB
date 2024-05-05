package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Service.dto.PayrollDTO;
import com.example.CompanyB.FinancePayRollModule.Model.EmployeePayroll;
import com.example.CompanyB.FinancePayRollModule.Repository.PayrollRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class PayrollService {
    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private TransactionService transactionService;

    @Autowired
    private PayrollCounterService payrollCounterService;

    public EmployeePayroll createPayroll(PayrollDTO payrollDTO) {
        EmployeePayroll payroll = new EmployeePayroll();
        int nextPayrollId = payrollCounterService.getNextPayrollId();
        String formattedPayrollId = String.format("PAY%05d", nextPayrollId);
        payroll.setPayrollId(formattedPayrollId);
        payroll.setEmployeeId(payrollDTO.getEmployeeId());
        payroll.setEmployeeName(payrollDTO.getEmployeeName());
        payroll.setBasicSalary(payrollDTO.getBasicSalary());
        payroll.setOtHours(payrollDTO.getOtHours());
        payroll.setWorkingDays(payrollDTO.getWorkingDays());
        payroll.setTaxPercentage(payrollDTO.getTaxPercentage());
        payroll.setDeductions(payrollDTO.getDeductions());
        payroll.setAllowance(payrollDTO.getAllowance());
        payroll.setPayrollDate(payrollDTO.getPayrollDate());
        payroll.setPayrollStartDate(payrollDTO.getPayrollStartDate());
        payroll.setPayrollEndDate(payrollDTO.getPayrollEndDate());

        double grossPay = (payroll.getBasicSalary() + (payroll.getOtHours() * payroll.getWorkingDays()));
        double taxAmount = grossPay * (payroll.getTaxPercentage() / 100);
        double deductions = payroll.getDeductions();
        double allowance = payroll.getAllowance();

        double netPay = grossPay - taxAmount - deductions + allowance;
        payroll.setNetPay(netPay);

        return payrollRepository.save(payroll);
    }

    public void deletePayroll(String id) {
        payrollRepository.deleteById(id);
    }

    public List<EmployeePayroll> getAllPayrollDetails() {
        return payrollRepository.findAll();
    }

    public EmployeePayroll getPayrollById(String id) {
        return payrollRepository.findById(id).orElseThrow(() -> new RuntimeException("Payroll not found"));
    }

    public EmployeePayroll updatePayroll(String id, EmployeePayroll updatedPayroll) {
        if (payrollRepository.existsById(id)) {
            updatedPayroll.setPayrollId(id);
            return payrollRepository.save(updatedPayroll);
        } else {
            throw new RuntimeException("Payroll not found");
        }
    }

    public List<EmployeePayroll> findPayrollsByEmployeeId(String employeeId) {
        return payrollRepository.findByEmployeeId(employeeId);
    }

    public byte[] generateExcelReport(List<EmployeePayroll> payrolls) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Employee Payrolls");

            String[] columns = {"Payroll ID", "Employee Name", "Basic Salary", "OT Hours", "Payroll Start Date", "Payroll End Date", "Working Days","Tax Percentage", "Deductions", "Allowance", "Net Pay", "Payroll Date"};
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            int rowNum = 1;
            for (EmployeePayroll payroll : payrolls) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(payroll.getPayrollId());
                row.createCell(1).setCellValue(payroll.getEmployeeName());
                row.createCell(2).setCellValue(payroll.getBasicSalary());
                row.createCell(3).setCellValue(payroll.getOtHours());
                row.createCell(4).setCellValue(payroll.getPayrollStartDate());
                row.createCell(5).setCellValue(payroll.getPayrollEndDate());
                row.createCell(6).setCellValue(payroll.getWorkingDays());
                row.createCell(7).setCellValue(payroll.getTaxPercentage());
                row.createCell(8).setCellValue(payroll.getDeductions());
                row.createCell(9).setCellValue(payroll.getAllowance());
                row.createCell(10).setCellValue(payroll.getNetPay());
                row.createCell(11).setCellValue(payroll.getPayrollDate().toString());
            }

            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(bos);
            return bos.toByteArray();
        }
    }

//    public EmployeePayroll processPayroll(EmployeePayroll payroll) {
//        // Save the payroll information
//        payroll = payrollRepository.save(payroll);
//
//        // Process the transaction related to payroll
//        transactionService.processPayrollTransaction(payroll.getNetPay());
//
//        return payroll;
//    }

}



