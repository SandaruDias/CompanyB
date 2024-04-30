package com.example.CompanyB.FinancePayRollModule.Service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.CompanyB.FinancePayRollModule.Model.Invoice;
import com.example.CompanyB.FinancePayRollModule.Repository.InvoiceRepository;
import com.example.CompanyB.FinancePayRollModule.Repository.PaymentTransactionRepository;
import com.example.CompanyB.FinancePayRollModule.Service.dto.InvoiceUpdateDTO;
import com.example.CompanyB.FinancePayRollModule.Service.dto.OrderDetailsDTO;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

// Correctly mocked WebClient setup
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class FinanceServiceTest {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Mock
    private WebClient webClient;

    @Mock
    private WebClient.RequestBodyUriSpec requestBodyUriSpec;

    @Mock
    private WebClient.RequestBodySpec requestBodySpec;

    @Mock
    private WebClient.ResponseSpec responseSpec;

    @InjectMocks
    private FinanceService financeService;

    @BeforeAll
    public void setupWebClient() {
        when(webClient.post()).thenReturn(requestBodyUriSpec);
        when(requestBodyUriSpec.uri("/sales/invoices")).thenReturn(requestBodySpec);
        when(requestBodySpec.contentType(MediaType.APPLICATION_JSON)).thenReturn(requestBodySpec);
        when(requestBodySpec.bodyValue(any(Invoice.class))).thenReturn(requestBodySpec);
        when(requestBodySpec.retrieve()).thenReturn(responseSpec);
        when(responseSpec.bodyToMono(String.class)).thenReturn(Mono.just("Success"));
    }

    @Test
    public void testCreateAndProcessInvoice() {
        OrderDetailsDTO orderDetails = new OrderDetailsDTO();
        orderDetails.setCustomerId("C123");
        orderDetails.setTotalAmount(1000.0);

        Invoice invoice = new Invoice();
        invoice.setCustomerId("C123");
        invoice.setAmount(1000.0);

        when(invoiceRepository.save(any(Invoice.class))).thenReturn(invoice);

        Invoice createdInvoice = financeService.createAndProcessInvoice(orderDetails);

        assertNotNull(createdInvoice);
        assertEquals("C123", createdInvoice.getCustomerId());
        verify(invoiceRepository).save(any(Invoice.class));
        verify(webClient).post();  // Ensure that the web client post method was called
    }

    @Test
    public void testUpdateInvoice() {
        Invoice invoice = new Invoice();
        invoice.setId("I123");
        invoice.setAmount(1000.0);
        invoice.setStatus(false);

        when(invoiceRepository.findById("I123")).thenReturn(java.util.Optional.of(invoice));

        InvoiceUpdateDTO updateDTO = new InvoiceUpdateDTO();
        updateDTO.setAmount(1200.0);
        updateDTO.setStatus(true);

        Invoice updatedInvoice = financeService.updateInvoice("I123", updateDTO);

        assertNotNull(updatedInvoice);
        assertEquals(1200.0, updatedInvoice.getAmount());
        assertTrue(updatedInvoice.getStatus());
        verify(invoiceRepository).save(invoice);
    }

    @Test
    public void testDeleteInvoice() {
        when(invoiceRepository.existsById("I123")).thenReturn(true);

        assertDoesNotThrow(() -> financeService.deleteInvoice("I123"));
        verify(invoiceRepository).deleteById("I123");
    }
}
