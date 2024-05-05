package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.SalesNotification;
import com.example.CompanyB.FinancePayRollModule.Service.SalesNotificationService;
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

class SalesNotificationControllerTest {

    @Mock
    private SalesNotificationService salesNotificationService;

    @InjectMocks
    private SalesNotificationController salesNotificationController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllSalesNotifications() {
        List<SalesNotification> expectedNotifications = new ArrayList<>();
        when(salesNotificationService.getAllSalesNotifications()).thenReturn(expectedNotifications);

        List<SalesNotification> notifications = salesNotificationController.getAllSalesNotifications();
        assertNotNull(notifications);
        assertEquals(expectedNotifications, notifications);
    }

    @Test
    void testCreateSalesNotification() {
        SalesNotification notification = new SalesNotification();
        when(salesNotificationService.saveSalesNotification(any(SalesNotification.class))).thenReturn(notification);

        SalesNotification createdNotification = salesNotificationController.createSalesNotification(notification);
        assertNotNull(createdNotification);
        assertSame(notification, createdNotification);
    }

    @Test
    void testGetSalesNotificationById() {
        String id = "testId";
        SalesNotification notification = new SalesNotification();
        when(salesNotificationService.getSalesNotificationById(id)).thenReturn(notification);

        ResponseEntity<SalesNotification> response = salesNotificationController.getSalesNotificationById(id);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(notification, response.getBody());
    }

    @Test
    void testDeleteSalesNotification() {
        String id = "testId";
        doNothing().when(salesNotificationService).deleteSalesNotification(id);

        ResponseEntity<Void> response = salesNotificationController.deleteSalesNotification(id);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(salesNotificationService, times(1)).deleteSalesNotification(id);
    }

    @Test
    void testUpdateProcessedStatus() {
        String id = "testId";
        boolean processed = true;
        SalesNotification notification = new SalesNotification();
        when(salesNotificationService.updateProcessedStatus(id, processed)).thenReturn(notification);

        SalesNotification updatedNotification = salesNotificationController.updateProcessedStatus(id, processed);
        assertNotNull(updatedNotification);
        assertSame(notification, updatedNotification);
    }
}
