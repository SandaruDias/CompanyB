package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.Notification;
import com.example.CompanyB.FinancePayRollModule.Repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification saveNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    public Notification getNotificationById(String id) {
        return notificationRepository.findById(id).orElseThrow(() -> new RuntimeException("Notification not found"));
    }

    public void deleteNotification(String id) {
        notificationRepository.deleteById(id);
    }

    public Notification updateProcessedStatus(String id, boolean processed) {
        Notification notification = getNotificationById(id);
        notification.setProcessed(processed);
        return notificationRepository.save(notification);
    }
}
