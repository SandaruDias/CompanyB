package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.Invoice;
import com.example.CompanyB.FinancePayRollModule.Model.PaymentTransaction;
import com.example.CompanyB.FinancePayRollModule.Repository.PaymentTransactionRepository;
import com.example.CompanyB.FinancePayRollModule.Repository.InvoiceRepository;
import com.example.CompanyB.FinancePayRollModule.Service.dto.OrderDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private PaymentTransactionRepository paymentTransactionRepository;


    public boolean validateCustomerCredit(String customerId) {
        // Implement logic to validate credit, possibly an API call to another service or a database check
        return true; // Simulated response
    }

    public Invoice createInvoice(OrderDetailsDTO orderDetails) {
        Invoice invoice = new Invoice();
        invoice.setCustomerId(orderDetails.getCustomerId());
        invoice.setAmount(orderDetails.getTotalAmount());

        // Calculate due date and other financial metrics
        invoice.setDueDate(new java.util.Date()); // Placeholder for actual logic
        invoice.setStatus(false); // Assuming invoice is initially not paid

        return (Invoice) invoiceRepository.save(invoice);
    }

    public PaymentTransaction recordPayment(String transactionId, Double amount, String paymentMethod, String customerId) {
        PaymentTransaction transaction = new PaymentTransaction();
        transaction.setId(transactionId);
        transaction.setCustomerId(customerId);
        transaction.setAmount(amount);
        transaction.setPaymentMethod(paymentMethod);
        transaction.setPaymentDate(new java.util.Date());
        return paymentTransactionRepository.save(transaction);
    }
}



