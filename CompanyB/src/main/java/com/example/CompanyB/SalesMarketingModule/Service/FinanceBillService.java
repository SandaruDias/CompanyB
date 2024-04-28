package com.example.CompanyB.SalesMarketingModule.Service;

import com.example.CompanyB.SalesMarketingModule.Model.FinanceBillModel;
import com.example.CompanyB.SalesMarketingModule.Repository.FinanceBillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanceBillService {

    @Autowired
    private FinanceBillRepository financeBillRepository;

    public void storeProfitAndSaleDetails(FinanceBillModel details) {
        // Save the received profit and sale details to the database
        financeBillRepository.save(details);
    }

    public String generateBill(String userId) {
        // Retrieve sale details for the user identified by userId from the database
        FinanceBillModel billDetails = financeBillRepository.findByUserId(userId);

        // Generate the bill omitting profit details
        double amountToPay = billDetails.getTotalSale();

        return "Total Amount to Pay: " + amountToPay;
    }
}
