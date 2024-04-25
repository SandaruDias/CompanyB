package com.example.CompanyB.ManufacturingModule.Controller;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.OnGoingOrder;
import com.example.CompanyB.ManufacturingModule.Service.FetchOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/FetchOrders")
public class FetchOrderController {

    private final FetchOrderService fetchOrderService;

    @Autowired
    public FetchOrderController(FetchOrderService fetchOrderService) {
        this.fetchOrderService = fetchOrderService;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> SetQuantityOfOngoingOrder(@PathVariable String orderId) {
        try {
            OnGoingOrder onGoingOrder=fetchOrderService.SetQuantityOfOngoingOrder(orderId);

            return ResponseEntity.ok().body(orderId +" Order Fetched Successfully. "+onGoingOrder.getTotalNumber() );
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + orderId);
        }
    }


}
