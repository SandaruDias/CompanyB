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
    @PutMapping("/invoices/{invoiceId}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable String invoiceId,
                                                 @RequestParam(required = false) Double amount,
                                                 @RequestParam(required = false) Boolean status) {
        try {
            Invoice updatedInvoice = financeService.updateInvoice(invoiceId, amount, status);
            return ResponseEntity.ok(updatedInvoice);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);  // Consider more specific error handling
        }
    }

    @PutMapping("/payments/{transactionId}")
    public ResponseEntity<PaymentTransaction> updatePayment(@PathVariable String transactionId,
                                                            @RequestParam Double amount,
                                                            @RequestParam String paymentMethod) {
        try {
            PaymentTransaction updatedTransaction = financeService.updatePayment(transactionId, amount, paymentMethod);
            return ResponseEntity.ok(updatedTransaction);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);  // Consider more specific error handling
        }
    }

}
