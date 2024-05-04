package com.example.CompanyB.SalesMarketingModule.Service;

import com.example.CompanyB.SalesMarketingModule.Model.SalesReportModel;
import com.example.CompanyB.SalesMarketingModule.Repository.SalesReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class SalesReportService {

    @Autowired
    private SalesReportRepository salesRepository;

    public  List<SalesReportModel> getAllSales() {
        return salesRepository.findAll();
    }

    public List<SalesReportModel> generateSalesReport(Date startDate, Date endDate) {
        return salesRepository.findBySaleDateBetween(startDate, endDate);
    }
}
