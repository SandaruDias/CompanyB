package com.example.CompanyB.SalesMarketingModule.Controller;

import com.example.CompanyB.SalesMarketingModule.Model.OrderModel;
import com.example.CompanyB.SalesMarketingModule.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("allOrders")
    public List<OrderModel> getAllOrders(Model model) {
        return orderService.getAllOrders();
        //model.addAttribute("orders", orders);
       // return "order-list"; // Assuming you have a Thymeleaf template named "order-list.html"
    }
}
