package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.Invoice;
import com.example.CompanyB.FinancePayRollModule.Model.PaymentTransaction;
import com.example.CompanyB.FinancePayRollModule.Service.FinanceService;
import com.example.CompanyB.FinancePayRollModule.Service.dto.InvoiceUpdateDTO;
import com.example.CompanyB.FinancePayRollModule.Service.dto.OrderDetailsDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class FinanceControllerTest {

    @InjectMocks
    private FinanceController financeController;

    @Mock
    private FinanceService financeService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createInvoice_shouldReturnInvoice_whenOrderDetailsAreValid() {
        // Arrange
        OrderDetailsDTO orderDetails = new OrderDetailsDTO();
        orderDetails.setCustomerId("123");
        orderDetails.setTotalAmount(1000.0);

        Invoice expectedInvoice = new Invoice();
        expectedInvoice.setId("1");
        expectedInvoice.setCustomerId("123");
        expectedInvoice.setAmount(1000.0);

        when(financeService.createAndProcessInvoice(any(OrderDetailsDTO.class))).thenReturn(expectedInvoice);

        // Act
        ResponseEntity<Invoice> response = financeController.createInvoice(orderDetails);

        // Assert
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedInvoice, response.getBody());

        verify(financeService).createAndProcessInvoice(any(OrderDetailsDTO.class));
    }

    @Test
    void processPayment_shouldReturnPaymentTransaction_whenDetailsAreValid() {
        // Arrange
        PaymentTransaction paymentDetails = new PaymentTransaction();
        paymentDetails.setInvoiceId("1");
        paymentDetails.setAmount(1000.0);
        paymentDetails.setPaymentMethod("Credit Card");
        paymentDetails.setCustomerId("123");

        when(financeService.processPayment(anyString(), anyDouble(), anyString(), anyString())).thenReturn(paymentDetails);

        // Act
        ResponseEntity<PaymentTransaction> response = financeController.processPayment(paymentDetails);

        // Assert
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(paymentDetails, response.getBody());

        verify(financeService).processPayment(anyString(), anyDouble(), anyString(), anyString());
    }

    @Test
    void updateInvoice_shouldReturnUpdatedInvoice_whenCalledWithValidParameters() {
        // Arrange
        String invoiceId = "1";
        InvoiceUpdateDTO invoiceDetails = new InvoiceUpdateDTO();
        invoiceDetails.setAmount(1200.0);
        invoiceDetails.setStatus(true);

        Invoice updatedInvoice = new Invoice();
        updatedInvoice.setId(invoiceId);
        updatedInvoice.setAmount(invoiceDetails.getAmount());
        updatedInvoice.setStatus(invoiceDetails.getStatus());

        when(financeService.updateInvoice(eq(invoiceId), any(InvoiceUpdateDTO.class))).thenReturn(updatedInvoice);

        // Act
        ResponseEntity<Invoice> response = financeController.updateInvoice(invoiceId, invoiceDetails);

        // Assert
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedInvoice, response.getBody());
        assertEquals(1200.0, response.getBody().getAmount());
        assertEquals(true, response.getBody().getStatus());

        verify(financeService).updateInvoice(eq(invoiceId), any(InvoiceUpdateDTO.class));
    }
}
