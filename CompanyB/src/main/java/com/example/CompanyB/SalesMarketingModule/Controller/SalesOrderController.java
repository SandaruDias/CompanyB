package com.example.CompanyB.SalesMarketingModule.Controller;

import com.example.CompanyB.SalesMarketingModule.Model.SalesOrderModel;
import com.example.CompanyB.SalesMarketingModule.Service.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("orders")
public class SalesOrderController {

    @Autowired
    private SalesOrderService salesOrderService;

    @GetMapping("allOrders")
    public List<SalesOrderModel> getAllOrders(Model model) {
        return salesOrderService.getAllOrders();
        //model.addAttribute("orders", orders);
       // return "order-list"; // Assuming you have a Thymeleaf template named "order-list.html"
    }

    @GetMapping("checkStock")
    public List<SalesOrderModel> checkStockAvailability(@RequestParam("orderId") String orderId, Model model) {
        // Fetch order details by orderId
        SalesOrderModel order = salesOrderService.fetchOrderDetails(orderId);

        // Check stock availability for the fetched order
        return Collections.singletonList(salesOrderService.checkStockAvailability(order));
    }
    /*@GetMapping("idChecker")
    public OrderModel fetchOrderDetails (){
        String orderId = "6628fae3201907206daaf19b";
        return orderService.fetchOrderDetails(orderId);
    }  */

}
