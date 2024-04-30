package com.example.CompanyB.FinancePayRollModule.Controller;

import com.example.CompanyB.FinancePayRollModule.Model.InventoryInvoice;
import com.example.CompanyB.FinancePayRollModule.Service.InventoryService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(InventoryController.class)
public class InventoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private InventoryService inventoryService;

    private InventoryInvoice invoice;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();

        invoice = new InventoryInvoice();
        invoice.setId("1");
        invoice.setMaterialName("Copper Wire");
        invoice.setQuantityShort(100);
        invoice.setMarketPrice(1.50);
        invoice.setPotentialLoss(150.00);
        invoice.setAdjustmentPlan("Order more");
        invoice.setUrgentOrderDetails("Immediate");
        invoice.setDueDate(new Date());
    }

    @Test
    public void testHandleInventoryShortage() throws Exception {
        given(inventoryService.processShortageReport(
                invoice.getinventoryInvoiceId(),
                invoice.getMaterialName(),
                invoice.getQuantityShort(),
                invoice.getMarketPrice(),
                invoice.getPotentialLoss(),
                invoice.getAdjustmentPlan(),
                invoice.getUrgentOrderDetails(),
                invoice.getDueDate())
        ).willReturn(invoice);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/inventory/processShortage")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invoice)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.materialName").value(invoice.getMaterialName()));
    }

    @Test
    public void testGetInvoiceById() throws Exception {
        given(inventoryService.getInvoiceById("1")).willReturn(invoice);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/inventory/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.materialName").value(invoice.getMaterialName()));
    }

    @Test
    public void testGetInvoicesByMaterialName() throws Exception {
        given(inventoryService.findInvoicesByMaterialName("Copper Wire")).willReturn(Arrays.asList(invoice));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/inventory/searchByMaterial")
                        .param("materialName", "Copper Wire"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].materialName").value("Copper Wire"));
    }

    @Test
    public void testGetInvoicesByPotentialLoss() throws Exception {
        given(inventoryService.findInvoicesWithHighPotentialLoss(100.00)).willReturn(Arrays.asList(invoice));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/inventory/searchByPotentialLoss")
                        .param("threshold", "100.00"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].potentialLoss").value(150.00));
    }

    @Test
    public void testGetInvoicesByDateRange() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startDate = sdf.parse("2023-01-01");
        Date endDate = sdf.parse("2023-12-31");
        given(inventoryService.findInvoicesByDateRange(startDate, endDate)).willReturn(Arrays.asList(invoice));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/inventory/searchByDateRange")
                        .param("start", "2023-01-01")
                        .param("end", "2023-12-31"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].materialName").value("Copper Wire"));
    }

    @Test
    public void testUpdateInvoice() throws Exception {
        // Arrange
        String invoiceId = "1";
        InventoryController.UpdateInvoiceRequest updateRequest = new InventoryController.UpdateInvoiceRequest();
        updateRequest.setAdjustmentPlan("Expedite shipping");
        updateRequest.setUrgentOrderDetails("Order more");

        InventoryInvoice invoice = new InventoryInvoice();
        invoice.setAdjustmentPlan("Expedite shipping");
        invoice.setUrgentOrderDetails("Order more");

        // Set up the expected behavior of the mock service
        given(inventoryService.updateInvoice(
                eq(invoiceId),
                eq(updateRequest.getAdjustmentPlan()),
                eq(updateRequest.getUrgentOrderDetails())
        )).willReturn(invoice);

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.put("/api/inventory/update/{id}", invoiceId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateRequest)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.adjustmentPlan").value("Expedite shipping"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.urgentOrderDetails").value("Order more"));
    }


    @Test
    public void testDownloadInvoiceReport() throws Exception {
        byte[] reportContent = new byte[] {1, 2, 3, 4, 5}; // Example binary data
        HttpHeaders headers = new HttpHeaders();
        headers.setContentDispositionFormData("attachment", "invoice-report-1.csv");

        given(inventoryService.downloadInvoiceReport("1")).willReturn(reportContent);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/inventory/download/{id}", "1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.header().string("Content-Disposition", "attachment; filename=invoice-report-1.csv"));
    }

}
