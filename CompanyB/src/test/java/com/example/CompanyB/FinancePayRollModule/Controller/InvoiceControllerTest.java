package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.Invoice;
import com.example.CompanyB.FinancePayRollModule.Service.InvoiceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class InvoiceControllerTest {

    @Mock
    private InvoiceService invoiceService;

    @InjectMocks
    private InvoiceController invoiceController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllInvoices() {
        List<Invoice> expectedList = new ArrayList<>();
        when(invoiceService.getAllInvoices()).thenReturn(expectedList);

        ResponseEntity<List<Invoice>> response = invoiceController.getAllInvoices();
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedList, response.getBody());
    }

    @Test
    void testGetInvoiceById_Found() {
        String id = "1";
        Optional<Invoice> invoice = Optional.of(new Invoice());
        when(invoiceService.getInvoiceById(id)).thenReturn(invoice);

        ResponseEntity<Invoice> response = invoiceController.getInvoiceById(id);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertTrue(response.getBody() instanceof Invoice);
    }

    @Test
    void testGetInvoiceById_NotFound() {
        String id = "1";
        when(invoiceService.getInvoiceById(id)).thenReturn(Optional.empty());

        ResponseEntity<Invoice> response = invoiceController.getInvoiceById(id);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testCreateInvoice() {
        Invoice invoice = new Invoice();
        when(invoiceService.createInvoice(invoice)).thenReturn(invoice);

        ResponseEntity<Invoice> response = invoiceController.createInvoice(invoice);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(invoice, response.getBody());
    }

    @Test
    void testUpdateInvoice_Found() {
        String id = "1";
        Invoice updatedInvoice = new Invoice();
        when(invoiceService.updateInvoice(id, updatedInvoice)).thenReturn(updatedInvoice);

        ResponseEntity<Invoice> response = invoiceController.updateInvoice(id, updatedInvoice);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedInvoice, response.getBody());
    }

    @Test
    void testUpdateInvoice_NotFound() {
        String id = "1";
        Invoice updatedInvoice = new Invoice();
        when(invoiceService.updateInvoice(id, updatedInvoice)).thenThrow(RuntimeException.class);

        ResponseEntity<Invoice> response = invoiceController.updateInvoice(id, updatedInvoice);
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void testDeleteInvoice() {
        String id = "1";
        doNothing().when(invoiceService).deleteInvoice(id);

        ResponseEntity<Void> response = invoiceController.deleteInvoice(id);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(invoiceService, times(1)).deleteInvoice(id);
    }

//    @Test
//    void testGetInvoicesByCustomerId() {
//        String customerId = "1";
//        List<Invoice> invoices = new ArrayList<>();
//        when(invoiceService.findInvoicesByCustomerId(customerId)).thenReturn(invoices);
//
//        ResponseEntity<List<Invoice>> response = invoiceController.getInvoicesByCustomerId(customerId);
//        assertNotNull(response);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//        assertEquals(invoices, response.getBody());
//    }

    @Test
    void testDownloadInvoicesByCustomerId_Success() throws IOException {
        String customerId = "1";
        List<Invoice> invoices = new ArrayList<>();
        byte[] data = new byte[10];
        when(invoiceService.findInvoicesByCustomerId(customerId)).thenReturn(invoices);
        when(invoiceService.generateExcelReportForInvoices(invoices)).thenReturn(data);

        ResponseEntity<InputStreamResource> response = invoiceController.downloadInvoicesByCustomerId(customerId);
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testDownloadInvoicesByCustomerId_Failure() throws IOException {
        String customerId = "1";
        when(invoiceService.findInvoicesByCustomerId(customerId)).thenReturn(new ArrayList<>());
        when(invoiceService.generateExcelReportForInvoices(anyList())).thenThrow(IOException.class);

        ResponseEntity<InputStreamResource> response = invoiceController.downloadInvoicesByCustomerId(customerId);
        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
