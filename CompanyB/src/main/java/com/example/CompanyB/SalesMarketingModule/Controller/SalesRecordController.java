package com.example.CompanyB.SalesMarketingModule.Controller;

import com.example.CompanyB.SalesMarketingModule.Model.SalesRecordModel;
import com.example.CompanyB.SalesMarketingModule.Service.SalesRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/records")
public class SalesRecordController {
    @Autowired
    private SalesRecordService salesRecordService;



    @PostMapping("/salesRecords")
    public ResponseEntity<String> processSalesRecords(@RequestBody List<SalesRecordModel> records) {
        salesRecordService.processSalesRecords(records);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sales records processed successfully.");
    }
}
