package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.InventoryInvoice;
import com.example.CompanyB.FinancePayRollModule.Model.ShortageReport;
import com.example.CompanyB.FinancePayRollModule.Service.AlertService;
import com.example.CompanyB.FinancePayRollModule.Service.InventoryService;
import com.example.CompanyB.FinancePayRollModule.Repository.InventoryInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/finance")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;
    
    @Autowired
    private InventoryInvoiceRepository inventoryInvoiceRepository;

    @Autowired
    private AlertService alertService;

    @PostMapping("/shortageReports")
    public ResponseEntity<InventoryInvoice> handleShortageReport(@RequestBody ShortageReport report) {
        InventoryInvoice invoice = inventoryService.assessFinancialRisks(report);
        return ResponseEntity.ok(invoice);
    }

    @GetMapping("/invoices")
    public ResponseEntity<Object> getAllInvoices() {
        List<InventoryInvoice> invoices = inventoryInvoiceRepository.findAll();
        return ResponseEntity.ok(invoices);
    }

    @GetMapping("/invoices/{id}")
    public ResponseEntity<InventoryInvoice> getInvoiceById(@PathVariable String id) {
        return inventoryInvoiceRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/sendAlert")
    public ResponseEntity<Void> sendAlert(@RequestBody InventoryInvoice invoice) {
        String message = buildAlertMessage(invoice);
        alertService.sendAlertToDepartments(message);
        return ResponseEntity.ok().build();
    }

    private String buildAlertMessage(InventoryInvoice invoice) {
        return String.format("Alert: Potential loss of $%.2f due to shortage of %s (Quantity Short: %d)",
                invoice.getPotentialLoss(), invoice.getMaterialName(), invoice.getQuantityShort());
    }

}
