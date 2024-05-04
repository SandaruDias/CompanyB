package com.example.CompanyB.SalesMarketingModule.Service;

import com.example.CompanyB.SalesMarketingModule.Model.SalesRecordModel;
import com.example.CompanyB.SalesMarketingModule.Repository.SalesRecordRepository;
import com.example.CompanyB.SalesMarketingModule.Repository.SalesReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;
import java.util.Optional;

@Service
public class SalesRecordService {
    @Autowired
    private SalesRecordRepository salesRecordRepository;

    public void processSalesRecords(List<SalesRecordModel> records) {
        for (SalesRecordModel record : records) {
            // Retrieve existing record from the database
            Optional<SalesRecordModel> existingRecordOptional = salesRecordRepository.findById(record.getProductId());

            if (existingRecordOptional.isPresent()) {
                SalesRecordModel existingRecord = existingRecordOptional.get();
                // Update the current profit and sold quantity
                existingRecord.setProfit(existingRecord.getProfit() + record.getProfit());
                existingRecord.setSoldQuantity(existingRecord.getSoldQuantity() + record.getSoldQuantity());
                // Save the updated record
                salesRecordRepository.save(existingRecord);
            } else {
                // If the record doesn't exist, simply save it
                salesRecordRepository.save(record);
            }
        }
    }
}
