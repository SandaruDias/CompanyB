package com.example.CompanyB.SalesMarketingModule.Controller;

import com.example.CompanyB.SalesMarketingModule.Model.SalesAnalysisModel;
import com.example.CompanyB.SalesMarketingModule.Service.SalesAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/salesAnalysis")
public class SalesAnalysisController {

    @Autowired
    private SalesAnalysisService salesService;

    @GetMapping("allSalesAnalysis")
    public List<SalesAnalysisModel> getAllSales(Model model) {
        return salesService.getAllSalesAnalysis();
        //model.addAttribute("orders", orders);
        // return "order-list"; // Assuming you have a Thymeleaf template named "order-list.html"
    }

    @GetMapping("/profit")
    @CrossOrigin(origins = "https://localhost:5173")
    public List<SalesAnalysisModel> getProfitBetween(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return salesService.getProfitBetween(startDate, endDate);
    }

    @GetMapping("/top3MostSoldProducts")
    public List<SalesAnalysisModel> getTop3MostSoldProducts(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return salesService.getTop3MostSoldProducts(startDate, endDate);
    }

    @GetMapping("/top3LeastSoldProducts")
    public List<SalesAnalysisModel> getTop3LeastSoldProducts(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return salesService.getTop3LeastSoldProducts(startDate, endDate);
    }
}
