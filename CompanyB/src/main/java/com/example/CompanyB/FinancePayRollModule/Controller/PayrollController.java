package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.EmployeePayroll;
import com.example.CompanyB.FinancePayRollModule.Model.Invoice;
import com.example.CompanyB.FinancePayRollModule.Service.PayrollService;
import com.example.CompanyB.FinancePayRollModule.Service.dto.PayrollDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @PostMapping
    public EmployeePayroll addPayroll(@RequestBody PayrollDTO payrollDTO) {
        return payrollService.createPayroll(payrollDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayroll(@PathVariable String id) {
        payrollService.deletePayroll(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<EmployeePayroll> getAllPayrolls() {
        return payrollService.getAllPayrollDetails();
    }

    @GetMapping("/{id}")
    public EmployeePayroll getPayrollById(@PathVariable String id) {
        return payrollService.getPayrollById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeePayroll> updatePayroll(@PathVariable String id, @RequestBody EmployeePayroll updatedPayroll) {
        try {
            return ResponseEntity.ok(payrollService.updatePayroll(id, updatedPayroll));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmployeePayroll>> getPayrollsByEmployeeId(@PathVariable String employeeId) {
        List<EmployeePayroll> payrolls = payrollService.findPayrollsByEmployeeId(employeeId);
        if (payrolls.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(payrolls);
    }

    @GetMapping("/download/{employeeId}")
    public ResponseEntity<InputStreamResource> downloadPayrollsByEmployeeId(@PathVariable String employeeId) {
        try {
            List<EmployeePayroll> payrolls = payrollService.findPayrollsByEmployeeId(employeeId);
            byte[] data = payrollService.generateExcelReport(payrolls);
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=payrolls.xlsx");
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                    .body(new InputStreamResource(new ByteArrayInputStream(data)));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
