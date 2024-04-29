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

    @PostMapping("/processOrder")
    public ResponseEntity<Invoice> processOrder(@RequestBody OrderDetailsDTO orderDetails) {
        boolean creditValid = financeService.validateCustomerCredit(orderDetails.getCustomerId());
        if (!creditValid) {
            return ResponseEntity.badRequest().body(null);
        }
        Invoice invoice = financeService.createInvoice(orderDetails);
        return ResponseEntity.ok(invoice);
    }

    @PostMapping("/recordPayment")
    public ResponseEntity<Object> recordPayment(@RequestBody PaymentTransaction paymentRequest) {
        PaymentTransaction transaction = financeService.recordPayment(
                paymentRequest.getTransactionId(),
                paymentRequest.getAmount(),
                paymentRequest.getPaymentMethod(),
                paymentRequest.getCustomerId()
        );
        return ResponseEntity.ok(transaction);
    }
}
