package com.example.CompanyB.SalesMarketingModule.Controller;

import com.example.CompanyB.SalesMarketingModule.Model.SalesReportModel;
import com.example.CompanyB.SalesMarketingModule.Service.SalesReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("sales")
public class SalesReportController {

    @Autowired
    private SalesReportService salesService;

    @GetMapping("/salesReport")
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
}
