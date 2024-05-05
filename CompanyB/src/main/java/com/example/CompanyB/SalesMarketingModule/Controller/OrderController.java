package com.example.CompanyB.SalesMarketingModule.Controller;

import com.example.CompanyB.SalesMarketingModule.Model.OrderModel;
import com.example.CompanyB.SalesMarketingModule.Service.OrderService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
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

    @GetMapping("checkStock")
    @CrossOrigin(origins = "https://localhost:5173")
    public List<OrderModel> checkStockAvailability(@RequestParam("orderId") String orderId, Model model) {
        // Fetch order details by orderId
        OrderModel order = orderService.fetchOrderDetails(orderId);

        // Check stock availability for the fetched order
        return Collections.singletonList(orderService.checkStockAvailability(order));
    }
    /*@GetMapping("idChecker")
    public OrderModel fetchOrderDetails (){
        String orderId = "6628fae3201907206daaf19b";
        return orderService.fetchOrderDetails(orderId);
    }  */

}
