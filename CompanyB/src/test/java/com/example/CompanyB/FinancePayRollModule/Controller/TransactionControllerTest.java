package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.Transaction;
import com.example.CompanyB.FinancePayRollModule.Service.TransactionService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpHeaders;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class TransactionControllerTest {

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private TransactionController transactionController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllTransactions() {
        List<Transaction> expectedList = new ArrayList<>();
        when(transactionService.getAllTransactionDetails()).thenReturn(expectedList);

        List<Transaction> response = transactionController.getAllTransacrions();
        assertNotNull(response);
        assertEquals(expectedList, response);
    }

    @Test
    void testProcessPayroll() {
        double amount = 1000.0;
        String payrollId = "123";
        Transaction transaction = new Transaction();
        when(transactionService.processPayrollTransaction(amount, payrollId)).thenReturn(transaction);

        Transaction response = transactionController.processPayroll(amount, payrollId);
        assertNotNull(response);
        assertEquals(transaction, response);
    }

    @Test
    void testProcessInvoice() {
        double amount = 2000.0;
        String invoiceId = "456";
        Transaction transaction = new Transaction();
        when(transactionService.processInvoiceTransaction(amount, invoiceId)).thenReturn(transaction);

        Transaction response = transactionController.processInvoice(amount, invoiceId);
        assertNotNull(response);
        assertEquals(transaction, response);
    }

    @Test
    void testGetCurrentBalance() {
        double expectedBalance = 5000.0;
        when(transactionService.getCurrentBalance()).thenReturn(expectedBalance);

        double response = transactionController.getCurrentBalance();
        assertEquals(expectedBalance, response, 0.001);
    }

    @Test
    void testDownloadTransaction_Success() throws IOException {
        List<Transaction> transactions = new ArrayList<>();
        byte[] data = new byte[10];
        when(transactionService.getAllTransactionDetails()).thenReturn(transactions);
        when(transactionService.generateExcelReportForTransactions(transactions)).thenReturn(data);

        ResponseEntity<InputStreamResource> response = transactionController.downloadTransaction();
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void testDownloadTransaction_Failure() throws IOException {
        when(transactionService.getAllTransactionDetails()).thenReturn(new ArrayList<>());
        when(transactionService.generateExcelReportForTransactions(anyList())).thenThrow(IOException.class);

        ResponseEntity<InputStreamResource> response = transactionController.downloadTransaction();
        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
