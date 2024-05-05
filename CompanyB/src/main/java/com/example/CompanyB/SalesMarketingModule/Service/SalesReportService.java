package com.example.CompanyB.SalesMarketingModule.Service;

import com.example.CompanyB.SalesMarketingModule.Model.SalesReportModel;
import com.example.CompanyB.SalesMarketingModule.Repository.SalesReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.HashMap;



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

   /* public Map<String, Integer> getItemsSoldBetween(Date startDate, Date endDate) {
        Map<String, Integer> itemsSold = new HashMap<>();

        // Retrieve sold items within the date range
        List<SalesReportModel> soldItems = salesRepository.findBySaleDateBetween(startDate, endDate);

        // Count the quantity sold for each product
        for (SalesReportModel item : soldItems) {
            String productId = item.getProductId();
            int quantitySold = item.getQuantitySold();

            // Update the item count
            itemsSold.put(productId, itemsSold.getOrDefault(productId, 0) + quantitySold);
        }

        return itemsSold;
    }
    public List<SalesReportModel> getTop3MostSoldProducts(Date startDate, Date endDate) {
        return salesRepository.findTop3BySaleDateBetweenOrderByQuantitySoldDesc(startDate, endDate);
    }

    // Method to retrieve top 3 least sold products within a given time range
    public List<SalesReportModel> getTop3LeastSoldProducts(Date startDate, Date endDate) {
        return salesRepository.findTop3BySaleDateBetweenOrderByQuantitySoldAsc(startDate, endDate);
    } */
}
