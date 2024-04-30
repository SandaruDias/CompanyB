package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.InventoryInvoice;
import com.example.CompanyB.FinancePayRollModule.Repository.InventoryInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private InventoryInvoiceRepository invoiceRepository;

    @Autowired
    private AlertService alertService;

    public InventoryInvoice processShortageReport(String inventoryInvoiceId,String materialName, int quantityShort, double marketPrice, double potentialLoss, String adjustmentPlan, String urgentOrderDetails, Date dueDate) {
        InventoryInvoice savedInvoice = new InventoryInvoice(inventoryInvoiceId, materialName, quantityShort, marketPrice, potentialLoss, adjustmentPlan, urgentOrderDetails, dueDate);
        invoiceRepository.save(savedInvoice);
        // Check if potential loss exceeds a certain threshold to send an alert
        if (savedInvoice.getPotentialLoss() > 10000) { // Threshold value can be set based on business requirements
            alertService.sendAlertToDepartments("High risk of loss detected: " + savedInvoice.getPotentialLoss() + " on material " + savedInvoice.getMaterialName());
        }
        return savedInvoice;
    }

    public List<InventoryInvoice> findInvoicesByMaterialName(String materialName) {
        return invoiceRepository.findByMaterialName(materialName);
    }

    public List<InventoryInvoice> findInvoicesWithHighPotentialLoss(double threshold) {
        return invoiceRepository.findByPotentialLossGreaterThan(threshold);
    }


    public List<InventoryInvoice> findInvoicesByAdjustmentPlan(String keyword) {
        return invoiceRepository.findByAdjustmentPlanContaining(keyword);
    }

    public List<InventoryInvoice> findInvoicesByDateRange(Date startDate, Date endDate) {
        return invoiceRepository.findByDueDateBetween(startDate, endDate);
    }

    public InventoryInvoice updateInvoice(String invoiceId, String newAdjustmentPlan, String newUrgentOrderDetails) {
        InventoryInvoice invoice = invoiceRepository.findById(invoiceId).orElseThrow(() -> new IllegalArgumentException("No invoice found with ID: " + invoiceId));
        invoice.setAdjustmentPlan(newAdjustmentPlan);
        invoice.setUrgentOrderDetails(newUrgentOrderDetails);
        return invoiceRepository.save(invoice);
    }

    public InventoryInvoice getInvoiceById(String invoiceId) {
        Optional<InventoryInvoice> invoice = invoiceRepository.findById(invoiceId);
        if (!invoice.isPresent()) {
            throw new IllegalArgumentException("No invoice found with ID: " + invoiceId);
        }
        return invoice.get();
    }

    public byte[] downloadInvoiceReport(String invoiceId) {
        InventoryInvoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new IllegalArgumentException("No invoice found with ID: " + invoiceId));
        return generateCsvReport(invoice);
    }

    private byte[] generateCsvReport(InventoryInvoice invoice) {
        String header = "Material Name,Quantity Short,Market Price,Potential Loss\n";
        String record = String.format("%s,%d,%.2f,%.2f\n",
                invoice.getMaterialName(),
                invoice.getQuantityShort(),
                invoice.getMarketPrice(),
                invoice.getPotentialLoss());

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            outputStream.write(header.getBytes(StandardCharsets.UTF_8));
            outputStream.write(record.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException("Failed to generate report", e);
        }
        return outputStream.toByteArray();
    }

}
