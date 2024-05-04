package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.SalesNotification;
import com.example.CompanyB.FinancePayRollModule.Repository.SalesNotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesNotificationService {

    @Autowired
    private SalesNotificationRepository salesNotificationRepository;

    public List<SalesNotification> getAllSalesNotifications() {
        return salesNotificationRepository.findAll();
    }

    public SalesNotification saveSalesNotification(SalesNotification notification) {
        return salesNotificationRepository.save(notification);
    }

    public SalesNotification getSalesNotificationById(String id) {
        return salesNotificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Sales Notification not found"));
    }

    public void deleteSalesNotification(String id) {
        salesNotificationRepository.deleteById(id);
    }

    public SalesNotification updateProcessedStatus(String id, boolean processed) {
        SalesNotification notification = getSalesNotificationById(id);
        notification.setProcessed(processed);
        return salesNotificationRepository.save(notification);
    }
}
