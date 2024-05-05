package com.example.CompanyB.HumanResourceManagementModule.Controller;

import com.example.CompanyB.HumanResourceManagementModule.Controller.EmployeeAttendanceController;
import com.example.CompanyB.HumanResourceManagementModule.Service.EmployeeAttendanceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class TPSEmployeeAttendanceControllerTest {

    @Mock
    private EmployeeAttendanceService employeeAttendanceService;

    @InjectMocks
    private EmployeeAttendanceController employeeAttendanceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void checkIn_ValidId_Success() {
        String id = "123";
        LocalDateTime checkInTime = LocalDateTime.now();

        when(employeeAttendanceService.isValidId(id)).thenReturn(true);
        when(employeeAttendanceService.recordCheckIn(id, checkInTime)).thenReturn("t");

        ResponseEntity<String> responseEntity = employeeAttendanceController.checkIn(id);

        assertEquals("Checked in successfully.", responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        verify(employeeAttendanceService, times(1)).isValidId(id);
        verify(employeeAttendanceService, times(1)).recordCheckIn(id, checkInTime);
    }

    @Test
    void checkIn_InvalidId_BadRequest() {
        String id = "456";

        when(employeeAttendanceService.isValidId(id)).thenReturn(false);

        ResponseEntity<String> responseEntity = employeeAttendanceController.checkIn(id);

        assertEquals("Invalid ID.", responseEntity.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        verify(employeeAttendanceService, times(1)).isValidId(id);
        verify(employeeAttendanceService, never()).recordCheckIn(anyString(), any());
    }

    @Test
    void checkOut_ValidId_Success() {
        String id = "123";
        LocalDateTime checkOutTime = LocalDateTime.now();

        when(employeeAttendanceService.isValidIdCheckout(id)).thenReturn(true);
        when(employeeAttendanceService.recordCheckOut(id, checkOutTime)).thenReturn("you can exit now -->");

        ResponseEntity<String> responseEntity = employeeAttendanceController.checkOut(id);

        assertEquals("Checked out successfully: you can exit now -->", responseEntity.getBody());
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        verify(employeeAttendanceService, times(1)).isValidIdCheckout(id);
        verify(employeeAttendanceService, times(1)).recordCheckOut(id, checkOutTime);
    }

    @Test
    void checkOut_InvalidId_BadRequest() {
        String id = "456";

        when(employeeAttendanceService.isValidIdCheckout(id)).thenReturn(false);

        ResponseEntity<String> responseEntity = employeeAttendanceController.checkOut(id);

        assertEquals("Your ID is not recorded when checking in.", responseEntity.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());

        verify(employeeAttendanceService, times(1)).isValidIdCheckout(id);
        verify(employeeAttendanceService, never()).recordCheckOut(anyString(), any());
    }
}