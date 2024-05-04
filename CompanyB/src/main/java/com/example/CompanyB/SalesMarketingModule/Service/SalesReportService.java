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

    public double getTotalSalesAmount() {
        List<SalesReportModel> sales = salesRepository.findAll();
        double totalSalesAmount = 0;
        for (SalesReportModel sale : sales) {
            totalSalesAmount += sale.getAmount();
        }
        return totalSalesAmount;
    }

    public double getTotalProfit() {
        List<SalesReportModel> sales = salesRepository.findAll();
        double totalProfit = 0;
        for (SalesReportModel sale : sales) {
            totalProfit += sale.getProfit();
        }
        return totalProfit;
    }

    public double getAverageProfitMargin() {
        double totalSalesAmount = getTotalSalesAmount();
        double totalProfit = getTotalProfit();
        if (totalSalesAmount != 0) {
            return totalProfit / totalSalesAmount;
        } else {
            return 0;
        }
    }
}
