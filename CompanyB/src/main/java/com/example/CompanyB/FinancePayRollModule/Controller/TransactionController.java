package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.EmployeePayroll;
import com.example.CompanyB.FinancePayRollModule.Model.Invoice;
import com.example.CompanyB.FinancePayRollModule.Model.Transaction;
import com.example.CompanyB.FinancePayRollModule.Service.TransactionService;
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
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> getAllTransacrions() {
        return transactionService.getAllTransactionDetails();
    }

    @PostMapping("/processPayroll")
    public Transaction processPayroll(@RequestParam double amount, @RequestParam String payrollId) {
        return transactionService.processPayrollTransaction(amount, payrollId);
    }

    @PostMapping("/processInvoice")
    public Transaction processInvoice(@RequestParam double amount, @RequestParam String invoiceId) {
        return transactionService.processInvoiceTransaction(amount, invoiceId);
    }

    @GetMapping("/currentBalance")
    public double getCurrentBalance() {
        return transactionService.getCurrentBalance();
    }

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadTransaction() throws IOException {
        try {
            List<Transaction> transactions = transactionService.getAllTransactionDetails();
            byte[] data = transactionService.generateExcelReportForTransactions(transactions);
            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=transactions.xlsx");
            return ResponseEntity.ok()
                    .headers(headers)
                    .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                    .body(new InputStreamResource(new ByteArrayInputStream(data)));
        } catch (IOException e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
