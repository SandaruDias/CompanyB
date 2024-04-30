package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.Invoice;
import com.example.CompanyB.FinancePayRollModule.Model.PaymentTransaction;
import com.example.CompanyB.FinancePayRollModule.Repository.InvoiceRepository;
import com.example.CompanyB.FinancePayRollModule.Repository.PaymentTransactionRepository;
import com.example.CompanyB.FinancePayRollModule.Service.dto.InvoiceUpdateDTO;
import com.example.CompanyB.FinancePayRollModule.Service.dto.OrderDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.http.MediaType;

@Service
public class FinanceService {
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private PaymentTransactionRepository paymentTransactionRepository;
    @Autowired
    private WebClient webClient;

    public Invoice createAndProcessInvoice(OrderDetailsDTO orderDetails) {
        Invoice invoice = new Invoice();
        invoice.setCustomerId(orderDetails.getCustomerId());
        invoice.setProducts(orderDetails.getProducts());
        invoice.setAmount(orderDetails.getTotalAmount());
        invoice.setDueDate(new java.util.Date());  // Set due date, assuming today for simplicity
        invoice.setStatus(false);  // Invoice initially unpaid

        invoiceRepository.save(invoice);
        sendInvoiceToSalesSystem(invoice);
        return invoice;
    }

    public PaymentTransaction processPayment(String invoiceId, Double amount, String paymentMethod, String customerId) {
        PaymentTransaction transaction = new PaymentTransaction();
        transaction.setCustomerId(customerId);
        transaction.setInvoiceId(invoiceId);  // Assuming you add this field to the model
        transaction.setAmount(amount);
        transaction.setPaymentMethod(paymentMethod);
        transaction.setPaymentDate(new java.util.Date());
        paymentTransactionRepository.save(transaction);

        updateInvoiceStatus(invoiceId, true);  // Mark as paid
        return transaction;
    }

    private void sendInvoiceToSalesSystem(Invoice invoice) {
        webClient.post()
                .uri("/sales/invoices")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(invoice)
                .retrieve()
                .bodyToMono(String.class)
                .subscribe(System.out::println);  // Handle response, possibly logging or further processing
    }

    private void updateInvoiceStatus(String invoiceId, Boolean status) {
        Invoice invoice = invoiceRepository.findById(invoiceId).orElseThrow();
        invoice.setStatus(status);
        invoiceRepository.save(invoice);
    }

    public Invoice updateInvoice(String invoiceId, InvoiceUpdateDTO invoiceDetails) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new IllegalArgumentException("Invoice not found with ID: " + invoiceId));

        if (invoiceDetails.getAmount() != null) {
            invoice.setAmount(invoiceDetails.getAmount());
        }
        if (invoiceDetails.getStatus() != null) {
            invoice.setStatus(invoiceDetails.getStatus());
        }

        return invoiceRepository.save(invoice);
    }

    public PaymentTransaction updatePayment(String transactionId, Double amount, String paymentMethod) {
        PaymentTransaction transaction = paymentTransactionRepository.findById(transactionId).orElseThrow(() -> new RuntimeException("Payment transaction not found"));
        transaction.setAmount(amount);
        transaction.setPaymentMethod(paymentMethod);
        paymentTransactionRepository.save(transaction);
        return transaction;
    }

    public void deleteInvoice(String invoiceId) {
        if (!invoiceRepository.existsById(invoiceId)) {
            throw new RuntimeException("Invoice not found with ID: " + invoiceId);
        }
        invoiceRepository.deleteById(invoiceId);
    }

    public void deletePayment(String transactionId) {
        if (!paymentTransactionRepository.existsById(transactionId)) {
            throw new RuntimeException("Payment transaction not found with ID: " + transactionId);
        }
        paymentTransactionRepository.deleteById(transactionId);
    }

}
