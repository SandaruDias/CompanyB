package com.example.CompanyB.HumanResourceManagementModule.Service;

import com.example.CompanyB.HumanResourceManagementModule.Model.Employee;
import com.example.CompanyB.HumanResourceManagementModule.Model.EmployeeAttendanceModel;
import com.example.CompanyB.HumanResourceManagementModule.Model.TotalHoursWorkedModel;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployeeAttendanceRepo;
import com.example.CompanyB.HumanResourceManagementModule.Repository.EmployeeRepo;
import com.example.CompanyB.HumanResourceManagementModule.Repository.TotalHoursWorkedRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TPSEmployeeAttendanceServiceTest {

    @Mock
    private EmployeeAttendanceRepo employeeAttendanceRepo;

    @Mock
    private EmployeeRepo employeeRepo;

    @Mock
    private TotalHoursWorkedRepo totalHoursWorkedRepo;

    @InjectMocks
    private EmployeeAttendanceService employeeAttendanceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void isValidId() {
        String id = "123";
        Employee employee = new Employee();
        when(employeeRepo.findById(id)).thenReturn(Optional.of(employee));

        assertTrue(employeeAttendanceService.isValidId(id));
    }

    @Test
    void isValidIdCheckout() {
        String id = "123";
        EmployeeAttendanceModel attendanceModel = new EmployeeAttendanceModel();
        when(employeeAttendanceRepo.findById(id)).thenReturn(Optional.of(attendanceModel));

        assertTrue(employeeAttendanceService.isValidIdCheckout(id));
    }

    @Test
    void isValidCheckInTime_ValidTime_True() {
        LocalDateTime checkInTime = LocalDateTime.of(2024, 5, 5, 7, 50);
        assertTrue(employeeAttendanceService.isValidCheckInTime(checkInTime));
    }

    @Test
    void isValidCheckInTime_InvalidTime_False() {
        LocalDateTime checkInTime = LocalDateTime.of(2024, 5, 5, 8, 20);
        assertFalse(employeeAttendanceService.isValidCheckInTime(checkInTime));
    }

    @Test
    void isValidCheckOutTime_ValidTime_True() {
        String id = "123";
        LocalDateTime checkOutTime = LocalDateTime.of(2024, 5, 5, 12, 20);
        assertTrue(employeeAttendanceService.isValidCheckOutTime(checkOutTime, id));
    }

    @Test
    void isValidCheckOutTime_InvalidTime_False() {
        String id = "123";
        LocalDateTime checkOutTime = LocalDateTime.of(2024, 5, 5, 8, 20);
        assertFalse(employeeAttendanceService.isValidCheckOutTime(checkOutTime, id));
    }

    @Test
    void recordCheckIn_ValidCheckInTime_Success() {
        String id = "123";
        LocalDateTime checkInTime = LocalDateTime.now();

        when(employeeAttendanceService.isValidCheckInTime(checkInTime)).thenReturn(true);
        when(employeeAttendanceRepo.save(any(EmployeeAttendanceModel.class))).thenReturn(new EmployeeAttendanceModel());

        assertEquals("t", employeeAttendanceService.recordCheckIn(id, checkInTime));
    }

    @Test
    void recordCheckOut_ValidCheckOutTime_Success() {
        String id = "123";
        LocalDateTime checkOutTime = LocalDateTime.now();

        EmployeeAttendanceModel attendanceModel = new EmployeeAttendanceModel();
        attendanceModel.setCheckInTime(LocalDateTime.now().minusHours(1));

        when(employeeAttendanceService.isValidCheckOutTime(checkOutTime, id)).thenReturn(true);
        when(employeeAttendanceRepo.findById(id)).thenReturn(Optional.of(attendanceModel));

        assertEquals("you can exit now -->" + id, employeeAttendanceService.recordCheckOut(id, checkOutTime));
    }
}
