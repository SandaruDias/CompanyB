package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.Notification;
import com.example.CompanyB.FinancePayRollModule.Service.NotificationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class NotificationControllerTest {

    @Mock
    private NotificationService notificationService;

    @InjectMocks
    private NotificationController notificationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllNotifications() {
        List<Notification> expectedNotifications = new ArrayList<>();
        when(notificationService.getAllNotifications()).thenReturn(expectedNotifications);

        List<Notification> notifications = notificationController.getAllNotifications();
        assertNotNull(notifications);
        assertEquals(expectedNotifications, notifications);
    }

    @Test
    void testCreateNotification() {
        Notification notification = new Notification();
        when(notificationService.saveNotification(any(Notification.class))).thenReturn(notification);

        Notification createdNotification = notificationController.createNotification(notification);
        assertNotNull(createdNotification);
        assertSame(notification, createdNotification);
    }

    @Test
    void testGetNotificationById() {
        String id = "testId";
        Notification notification = new Notification();
        when(notificationService.getNotificationById(id)).thenReturn(notification);

        ResponseEntity<Notification> response = notificationController.getNotificationById(id);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(notification, response.getBody());
    }

    @Test
    void testDeleteNotification() {
        String id = "testId";
        doNothing().when(notificationService).deleteNotification(id);

        ResponseEntity<Void> response = notificationController.deleteNotification(id);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(notificationService, times(1)).deleteNotification(id);
    }

    @Test
    void testUpdateProcessedStatus() {
        String id = "testId";
        boolean processed = true;
        Notification notification = new Notification();
        when(notificationService.updateProcessedStatus(id, processed)).thenReturn(notification);

        Notification updatedNotification = notificationController.updateProcessedStatus(id, processed);
        assertNotNull(updatedNotification);
        assertSame(notification, updatedNotification);
    }
}
