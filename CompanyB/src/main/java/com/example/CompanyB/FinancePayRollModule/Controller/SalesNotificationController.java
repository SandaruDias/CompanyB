package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.SalesNotification;
import com.example.CompanyB.FinancePayRollModule.Service.SalesNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales-notifications")
public class SalesNotificationController {

    @Autowired
    private SalesNotificationService salesNotificationService;

    @GetMapping
    public List<SalesNotification> getAllSalesNotifications() {
        return salesNotificationService.getAllSalesNotifications();
    }

    @PostMapping
    public SalesNotification createSalesNotification(@RequestBody SalesNotification notification) {
        return salesNotificationService.saveSalesNotification(notification);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalesNotification> getSalesNotificationById(@PathVariable String id) {
        SalesNotification notification = salesNotificationService.getSalesNotificationById(id);
        return ResponseEntity.ok(notification);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSalesNotification(@PathVariable String id) {
        salesNotificationService.deleteSalesNotification(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}/processed")
    public SalesNotification updateProcessedStatus(@PathVariable String id, @RequestBody boolean processed) {
        return salesNotificationService.updateProcessedStatus(id, processed);
    }
}
