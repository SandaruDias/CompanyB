package com.example.CompanyB.SalesMarketingModule.Controller;

import com.example.CompanyB.SalesMarketingModule.Model.FinanceBillModel;
import com.example.CompanyB.SalesMarketingModule.Service.FinanceBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/financeBill")
public class FinanceBillController {

    @Autowired
    private FinanceBillService financeBillService;

    @PostMapping("/storeProfitAndSaleDetails")
    public ResponseEntity<String> storeProfitAndSaleDetails(@RequestBody FinanceBillModel details) {
        financeBillService.storeProfitAndSaleDetails(details);
        return ResponseEntity.ok("Profit and sale details stored successfully.");
    }

    @GetMapping("/generateBill")
    public ResponseEntity<String> generateBill(@RequestParam("userId") String userId) {
        // Generate the bill for the user identified by userId
        String bill = financeBillService.generateBill(userId);
        return ResponseEntity.ok(bill);
    }
}
