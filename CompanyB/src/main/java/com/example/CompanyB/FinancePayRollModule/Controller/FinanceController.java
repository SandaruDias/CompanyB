package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.Invoice;
import com.example.CompanyB.FinancePayRollModule.Model.PaymentTransaction;
import com.example.CompanyB.FinancePayRollModule.Service.FinanceService;
import com.example.CompanyB.FinancePayRollModule.Service.dto.OrderDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {
    @Autowired
    private FinanceService financeService;

    @PostMapping("/invoices")
    public ResponseEntity<Invoice> createInvoice(@RequestBody OrderDetailsDTO orderDetails) {
        Invoice invoice = financeService.createAndProcessInvoice(orderDetails);
        return ResponseEntity.ok(invoice);
    }

    @PostMapping("/payments")
    public ResponseEntity<PaymentTransaction> processPayment(@RequestParam String invoiceId,
                                                             @RequestParam Double amount,
                                                             @RequestParam String paymentMethod,
                                                             @RequestParam String customerId) {
        PaymentTransaction transaction = financeService.processPayment(invoiceId, amount, paymentMethod, customerId);
        return ResponseEntity.ok(transaction);
    }

    // Add more endpoints for admin functionalities like editing invoice and payments
}
