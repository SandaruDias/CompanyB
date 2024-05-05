package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.EmployeePayroll;
import com.example.CompanyB.FinancePayRollModule.Model.Invoice;
import com.example.CompanyB.FinancePayRollModule.Repository.InvoiceRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
    public byte[] generateExcelReportForInvoices(List<Invoice> invoices) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Order Invoices");

            String[] columns = {"Invoice ID", "Order ID", "Customer ID", "Sub Total", "Tax", "Total", "Payment Status", "Invoice Date"};
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            int rowNum = 1;
            for (Invoice invoice : invoices) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(invoice.getInvoiceId());
                row.createCell(1).setCellValue(invoice.getOrderId());
                row.createCell(2).setCellValue(invoice.getCustomerId());
                row.createCell(3).setCellValue(invoice.getSubtotal());
                row.createCell(4).setCellValue(invoice.getTax());
                row.createCell(5).setCellValue(invoice.getTotal());
                row.createCell(6).setCellValue(invoice.getPaymentStatus());
                row.createCell(7).setCellValue(invoice.getInvoiceDate());
            }

            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(bos);
            return bos.toByteArray();
        }
    }

    public Invoice createInvoice(Invoice invoice) {
        // Generate a new serial invoice ID
        int nextInvoiceId = invoiceCounterService.getNextInvoiceId();
        String formattedInvoiceId = String.format("INV%05d", nextInvoiceId);
        invoice.setInvoiceId(formattedInvoiceId);
        return invoiceRepository.save(invoice);
    }

//    public Invoice processInvoice(Invoice invoice) {
//        invoice = invoiceRepository.save(invoice);
//        transactionService.processInvoiceTransaction(invoice.getTotal());
//        return invoice;
//    }
}
