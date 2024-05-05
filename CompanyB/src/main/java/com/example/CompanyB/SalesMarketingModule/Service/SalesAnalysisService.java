package com.example.CompanyB.SalesMarketingModule.Service;

import com.example.CompanyB.SalesMarketingModule.Model.SalesAnalysisModel;
import com.example.CompanyB.SalesMarketingModule.Repository.SalesAnalysisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SalesAnalysisService {

    @Autowired
    private SalesAnalysisRepository salesAnalysisRepository;

    public Map<String, Integer> getItemsSoldBetween(Date startDate, Date endDate) {
        Map<String, Integer> itemsSold = new HashMap<>();

        List<SalesAnalysisModel> soldItems = salesAnalysisRepository.findBySaleDateBetween(startDate, endDate);

        for (SalesAnalysisModel item : soldItems) {
            String productId = item.getProductId();
            int quantitySold = item.getQuantitySold();

            itemsSold.put(productId, itemsSold.getOrDefault(productId, 0) + quantitySold);
        }

        return itemsSold;
    }

    public List<SalesAnalysisModel> getTop3MostSoldProducts(Date startDate, Date endDate) {
        return salesAnalysisRepository.findTop3BySaleDateBetweenOrderByQuantitySoldDesc(startDate, endDate);
    }

    public List<SalesAnalysisModel> getTop3LeastSoldProducts(Date startDate, Date endDate) {
        return salesAnalysisRepository.findTop3BySaleDateBetweenOrderByQuantitySoldAsc(startDate, endDate);
    }

    public List<SalesAnalysisModel> getAllSalesAnalysis() {
        return salesAnalysisRepository.findAll();
    }
}
