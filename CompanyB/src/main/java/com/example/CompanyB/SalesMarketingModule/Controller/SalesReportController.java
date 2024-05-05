package com.example.CompanyB.SalesMarketingModule.Controller;

import com.example.CompanyB.SalesMarketingModule.Model.SalesReportModel;
import com.example.CompanyB.SalesMarketingModule.Service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("sales")
public class SalesReportController {

    @Autowired
    private SalesReportService salesService;

    @GetMapping("/salesReport")
    @CrossOrigin (origins = "https://localhost:5173")
    public List<SalesReportModel> generateSalesReport(
            @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
            @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return salesService.generateSalesReport(startDate, endDate);
    }
    @GetMapping("allSales")
    public List<SalesReportModel> getAllSales(Model model) {
        return salesService.getAllSales();
        //model.addAttribute("orders", orders);
        // return "order-list"; // Assuming you have a Thymeleaf template named "order-list.html"
    }
    @GetMapping("/totalSalesAmount")
    public double getTotalSalesAmount() {
        return salesService.getTotalSalesAmount();
    }

    @GetMapping("/totalProfit")
    public double getTotalProfit() {
        return salesService.getTotalProfit();
    }

    @GetMapping("/averageProfitMargin")
    public double getAverageProfitMargin() {
        return salesService.getAverageProfitMargin();
    }

}
