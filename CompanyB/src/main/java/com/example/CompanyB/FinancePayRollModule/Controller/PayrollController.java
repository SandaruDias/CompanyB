package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.Payroll;
import com.example.CompanyB.FinancePayRollModule.Service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {
    private final PayrollService payrollService;

    @Autowired
    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<Payroll> calculatePayroll(@RequestParam Long employeeId,
                                                    @RequestParam Double hoursWorked,
                                                    @RequestParam Double hourlyRate,
                                                    @RequestParam Double overtimeHours,
                                                    @RequestParam Double overtimeRate,
                                                    @RequestParam Double deductions) {
        Payroll payroll = payrollService.calculateAndSavePayroll(employeeId, hoursWorked, hourlyRate, overtimeHours, overtimeRate, deductions);
        return ResponseEntity.ok(payroll);
    }
}