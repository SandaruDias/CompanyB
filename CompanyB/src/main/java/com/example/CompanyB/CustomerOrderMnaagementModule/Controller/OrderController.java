package com.example.CompanyB.CustomerOrderMnaagementModule.Controller;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CompanyB.CustomerOrderMnaagementModule.Model.OrderModel;
import com.example.CompanyB.CustomerOrderMnaagementModule.Service.OrderService;

@RestController
@RequestMapping("/customer/order")

public class OrderController {

    
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderModel>> getallOrders() {
        return new ResponseEntity<List<OrderModel>>(orderService.allOrders(), HttpStatus.OK);
    }
    
    @GetMapping("/{customerId}")
    public ResponseEntity<Optional<OrderModel>> getSingleOrder(@PathVariable String customerId) {
        return new ResponseEntity<Optional<OrderModel>>(orderService.singleOrder(customerId),HttpStatus.OK);
    }
    
}
