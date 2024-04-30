package com.example.CompanyB.ManufacturingModule.Controller;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.OnGoingOrder;
import com.example.CompanyB.ManufacturingModule.Service.FetchOrderService;
import com.example.CompanyB.ManufacturingModule.Service.OnGoingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/FetchOrders")
public class FetchOrderController {

    private final FetchOrderService fetchOrderService;

    @Autowired
    public FetchOrderController(FetchOrderService fetchOrderService) {
        this.fetchOrderService = fetchOrderService;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> FetchOrderFromOrderDetails(@PathVariable String orderId) {
        try {
            String result = fetchOrderService.checkQuantity(orderId);
            String ID= fetchOrderService.printID(orderId);
            OnGoingOrder onGoingOrder=fetchOrderService.fetchOrderFromOrderDetails(orderId);
            return ResponseEntity.ok().body(onGoingOrder);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + orderId);
        }
    }
}
