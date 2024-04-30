package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.Invoice;
import com.example.CompanyB.FinancePayRollModule.Model.PaymentTransaction;
import com.example.CompanyB.FinancePayRollModule.Service.FinanceService;
import com.example.CompanyB.FinancePayRollModule.Service.dto.OrderDetailsDTO;
import com.example.CompanyB.FinancePayRollModule.Service.dto.InvoiceUpdateDTO;
import com.example.CompanyB.FinancePayRollModule.Service.dto.PaymentUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/finance")
public class FinanceController {
    @Autowired
    private FinanceService financeService;

    @PostMapping("/invoices")
    public ResponseEntity<Invoice> createInvoice(@RequestBody OrderDetailsDTO orderDetails) {
        try {
            Invoice invoice = financeService.createAndProcessInvoice(orderDetails);
            return ResponseEntity.ok(invoice);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/payments")
    public ResponseEntity<PaymentTransaction> processPayment(@RequestBody PaymentTransaction paymentDetails) {
        try {
            PaymentTransaction transaction = financeService.processPayment(
                    paymentDetails.getInvoiceId(), paymentDetails.getAmount(), paymentDetails.getPaymentMethod(), paymentDetails.getCustomerId());
            return ResponseEntity.ok(transaction);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PutMapping("/invoices/{invoiceId}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable String invoiceId,
                                                 @RequestBody InvoiceUpdateDTO invoiceDetails) {
        try {
            Invoice updatedInvoice = financeService.updateInvoice(invoiceId, invoiceDetails);
            return ResponseEntity.ok(updatedInvoice);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/payments/{transactionId}")
    public ResponseEntity<PaymentTransaction> updatePayment(@PathVariable String transactionId,
                                                            @RequestBody PaymentUpdateDTO paymentDetails) {
        try {
            PaymentTransaction updatedTransaction = financeService.updatePayment(transactionId, paymentDetails.getAmount(), paymentDetails.getPaymentMethod());
            return ResponseEntity.ok(updatedTransaction);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/invoices/{invoiceId}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable String invoiceId) {
        try {
            financeService.deleteInvoice(invoiceId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/payments/{transactionId}")
    public ResponseEntity<Void> deletePayment(@PathVariable String transactionId) {
        try {
            financeService.deletePayment(transactionId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
