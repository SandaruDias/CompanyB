package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.InventoryInvoice;
import com.example.CompanyB.FinancePayRollModule.Model.ShortageReport;
import com.example.CompanyB.FinancePayRollModule.Repository.InventoryInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryInvoiceRepository invoiceRepository;

    public InventoryInvoice assessFinancialRisks(ShortageReport report) {
        InventoryInvoice invoice = new InventoryInvoice();
        invoice.setMaterialName(report.getMaterialName());
        invoice.setQuantityShort(report.getQuantityShort());
        invoice.setMarketPrice(calculateMarketPrice(report.getMaterialId()));
        invoice.setPotentialLoss(calculatePotentialLoss(report.getQuantityShort(), invoice.getMarketPrice()));

        return invoiceRepository.save(invoice);
    }

    private double calculateMarketPrice(String materialId) {
        // Implement market price calculation based on external data or internal rules
        return 100.0; // Placeholder value
    }

    private double calculatePotentialLoss(int quantityShort, double marketPrice) {
        return quantityShort * marketPrice; // Simple calculation
    }

    public List<InventoryInvoice> findAllInvoices() {
        return invoiceRepository.findAll();
    }
}

