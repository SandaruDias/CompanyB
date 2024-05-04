package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.Transaction;
import com.example.CompanyB.FinancePayRollModule.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/processPayroll")
    public Transaction processPayroll(@RequestParam double amount) {
        transactionService.processPayrollTransaction(amount);
        return null;
    }

    @PostMapping("/processInvoice")
    public Transaction processInvoice(@RequestParam double amount) {
        transactionService.processInvoiceTransaction(amount);
        return null;
    }
}
