package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.Payroll;
import com.example.CompanyB.FinancePayRollModule.Service.PayrollService;
import com.example.CompanyB.FinancePayRollModule.Repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {
    private final PayrollService payrollService;

    @Autowired
    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @Autowired
    public PayrollRepository payrollRepository;

    @PostMapping("/calculate")
    public ResponseEntity<Payroll> calculatePayroll(@RequestParam Long employeeId,
                                                    @RequestParam String employeeName,
                                                    @RequestParam Double hoursWorked,
                                                    @RequestParam Double hourlyRate,
                                                    @RequestParam Double overtimeHours,
                                                    @RequestParam Double overtimeRate,
                                                    @RequestParam Double deductions,
                                                    @RequestParam Double taxRate) {
        Payroll payroll = payrollService.calculateAndSavePayroll(employeeId, employeeName, hoursWorked, hourlyRate, overtimeHours, overtimeRate, deductions, taxRate);
        return ResponseEntity.ok(payroll);
    }

    @GetMapping("/{payrollId}")
    public ResponseEntity<Payroll> getPayrollById(@PathVariable String payrollId) {
        Payroll payroll = payrollService.findPayrollById(payrollId);
        return ResponseEntity.ok(payroll);
    }

    @PutMapping("/update/{payrollId}")
    public ResponseEntity<Payroll> updatePayroll(@PathVariable String payrollId,
                                                 @RequestParam Double deductions,
                                                 @RequestParam Double taxRate) {
        Payroll updatedPayroll = payrollService.updatePayroll(payrollId, deductions, taxRate);
        return ResponseEntity.ok(updatedPayroll);
    }

    // In your PayrollController
    @GetMapping("/download/{employeeId}")
    public ResponseEntity<byte[]> downloadPayrollDetails(@PathVariable Long employeeId) {
        List<Payroll> payrolls = payrollRepository.findByEmployeeId(employeeId, Pageable.unpaged()).getContent();
        byte[] data = payrollService.generatePayrollReport(payrolls);
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=payroll-report.csv");
        return new ResponseEntity<>(data, headers, HttpStatus.OK);
    }

}
