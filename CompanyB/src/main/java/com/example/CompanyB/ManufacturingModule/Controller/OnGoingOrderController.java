package com.example.CompanyB.ManufacturingModule.Controller;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.OnGoingOrder;
import com.example.CompanyB.ManufacturingModule.Service.OnGoingOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/OnGoingOrder")

public class OnGoingOrderController {

    @Autowired
    private final OnGoingOrderService onGoingOrderService;

    public OnGoingOrderController(OnGoingOrderService onGoingOrderService) {
        this.onGoingOrderService = onGoingOrderService;
    }


    @GetMapping("GetCompletedNumber/{orderId}")
    public ResponseEntity<?> GetCompletedNumber(@PathVariable String orderId) {
        try {
            int completed = onGoingOrderService.GetCompletedNumber(orderId);

            return ResponseEntity.ok().body("Completed Items: " + completed);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + orderId);
        }
    }

    @PutMapping("/WorkstationOneFetch/{orderID}")
    public ResponseEntity<?> WorkStationOneFetch(@PathVariable String orderID) {
        try {
            OnGoingOrder onGoingOrder = onGoingOrderService.WorkstationOneFetch(orderID);
            return ResponseEntity.ok().body(orderID+ "Completed " +onGoingOrder.toString() );
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + orderID);
        }
    }

}
