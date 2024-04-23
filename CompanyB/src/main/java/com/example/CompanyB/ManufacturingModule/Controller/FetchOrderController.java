package com.example.CompanyB.ManufacturingModule.Controller;

import com.example.CompanyB.ManufacturingModule.Service.FetchOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class FetchOrderController {

    private final FetchOrderService fetchOrderService;

    @Autowired
    public FetchOrderController(FetchOrderService fetchOrderService) {
        this.fetchOrderService = fetchOrderService;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> checkQuantity(@PathVariable String orderId) {
        try {
            String result = fetchOrderService.checkQuantity(orderId);
            String ID= fetchOrderService.PrintID(orderId);
            return ResponseEntity.ok().body(result + ", ID: " + ID);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + orderId);
        }
    }
}
