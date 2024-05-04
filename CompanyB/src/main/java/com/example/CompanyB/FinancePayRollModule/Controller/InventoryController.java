//package com.example.CompanyB.FinancePayRollModule.Controller;
//
//import com.example.CompanyB.FinancePayRollModule.Model.InventoryInvoice;
//import com.example.CompanyB.FinancePayRollModule.Service.InventoryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/inventory")
//public class InventoryController {
//    @Autowired
//    private InventoryService inventoryService;
//
//    @PostMapping("/processShortage")
//    public ResponseEntity<InventoryInvoice> handleInventoryShortage(@RequestBody InventoryInvoice inventoryInvoice) {
//        InventoryInvoice processedInvoice = inventoryService.processShortageReport(
//                inventoryInvoice.getinventoryInvoiceId(),
//                inventoryInvoice.getMaterialName(),
//                inventoryInvoice.getQuantityShort(),
//                inventoryInvoice.getMarketPrice(),
//                inventoryInvoice.getPotentialLoss(),
//                inventoryInvoice.getAdjustmentPlan(),
//                inventoryInvoice.getUrgentOrderDetails(),
//                inventoryInvoice.getDueDate());
//        return ResponseEntity.ok(processedInvoice);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<InventoryInvoice> getInvoiceById(@PathVariable String id) {
//        InventoryInvoice invoice = inventoryService.getInvoiceById(id);
//        return ResponseEntity.ok(invoice);
//    }
//
//    @GetMapping("/searchByMaterial")
//    public ResponseEntity<List<InventoryInvoice>> getInvoicesByMaterialName(@RequestParam String materialName) {
//        List<InventoryInvoice> invoices = inventoryService.findInvoicesByMaterialName(materialName);
//        return ResponseEntity.ok(invoices);
//    }
//
//    @GetMapping("/searchByPotentialLoss")
//    public ResponseEntity<List<InventoryInvoice>> getInvoicesByPotentialLoss(@RequestParam double threshold) {
//        List<InventoryInvoice> invoices = inventoryService.findInvoicesWithHighPotentialLoss(threshold);
//        return ResponseEntity.ok(invoices);
//    }
//
//    @GetMapping("/searchByDateRange")
//    public ResponseEntity<List<InventoryInvoice>> getInvoicesByDateRange(@RequestParam String start, @RequestParam String end) throws ParseException {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date startDate = sdf.parse(start);
//        Date endDate = sdf.parse(end);
//        List<InventoryInvoice> invoices = inventoryService.findInvoicesByDateRange(startDate, endDate);
//        return ResponseEntity.ok(invoices);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<InventoryInvoice> updateInvoice(@PathVariable String id, @RequestBody UpdateInvoiceRequest updateRequest) {
//        InventoryInvoice updatedInvoice = inventoryService.updateInvoice(
//                id,
//                updateRequest.getAdjustmentPlan(),
//                updateRequest.getUrgentOrderDetails()
//        );
//        return ResponseEntity.ok(updatedInvoice);
//    }
//
//    @GetMapping("/download/{id}")
//    public ResponseEntity<byte[]> downloadInvoiceReport(@PathVariable String id) {
//        byte[] data = inventoryService.downloadInvoiceReport(id);
//        HttpHeaders headers = new HttpHeaders();
//        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=invoice-report-" + id + ".csv");
//        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//        return new ResponseEntity<>(data, headers, HttpStatus.OK);
//    }
//
//    static class UpdateInvoiceRequest {
//        private String adjustmentPlan;
//        private String urgentOrderDetails;
//
//        // Getters and Setters
//        public String getAdjustmentPlan() {
//            return adjustmentPlan;
//        }
//
//        public void setAdjustmentPlan(String adjustmentPlan) {
//            this.adjustmentPlan = adjustmentPlan;
//        }
//
//        public String getUrgentOrderDetails() {
//            return urgentOrderDetails;
//        }
//
//        public void setUrgentOrderDetails(String urgentOrderDetails) {
//            this.urgentOrderDetails = urgentOrderDetails;
//        }
//    }
//}
