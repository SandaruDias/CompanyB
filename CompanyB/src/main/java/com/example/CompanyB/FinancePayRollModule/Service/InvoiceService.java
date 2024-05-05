package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.Invoice;
import com.example.CompanyB.FinancePayRollModule.Repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;


    @Autowired
    private TransactionService transactionService;

    @Autowired
    private InvoiceCounterService invoiceCounterService;

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(String id) {
        return invoiceRepository.findById(id);
    }

    public Invoice updateInvoice(String id, Invoice updatedInvoice) {
        if (invoiceRepository.existsById(id)) {
            updatedInvoice.setInvoiceId(id);
            return invoiceRepository.save(updatedInvoice);
        } else {
            throw new RuntimeException("Invoice not found");
        }
    }

    public void deleteInvoice(String id) {
        invoiceRepository.deleteById(id);
    }

    public List<Invoice> findInvoicesByCustomerId(String customerId) {
        // Assuming method exists in repository to fetch by customer ID
        return invoiceRepository.findByCustomerId(customerId);
    }

    public byte[] generateExcelReportForInvoices(List<Invoice> invoices) {
        // This would involve generating an Excel file with data from the invoices list
        // Implementation would depend on the library used (e.g., Apache POI)
        // This is a placeholder for your implementation
        return new byte[0]; // Placeholder return value
    }

    public Invoice createInvoice(Invoice invoice) {
        // Generate a new serial invoice ID
        int nextInvoiceId = invoiceCounterService.getNextInvoiceId();
        String formattedInvoiceId = String.format("INV%05d", nextInvoiceId);
        invoice.setInvoiceId(formattedInvoiceId);

        // Set the current date as invoice date
//        invoice.setInvoiceDate(new Date());

        // Save and return the new invoice
        return invoiceRepository.save(invoice);
    }

//    public Invoice processInvoice(Invoice invoice) {
//        invoice = invoiceRepository.save(invoice);
//        transactionService.processInvoiceTransaction(invoice.getTotal());
//        return invoice;
//    }
}
