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

    @GetMapping("GetOrderToWorkStation/{orderId}")
    public ResponseEntity<?> GetOrderToWorkStation(@PathVariable String orderId) {
        try {

            return ResponseEntity.ok().body(onGoingOrderService.GetOrderToWorkStation(orderId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + orderId);
        }
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

    @PutMapping("/WorkstationOneFetch/{orderID}/{amount}")
    public ResponseEntity<?> WorkStationOneFetch(@PathVariable String orderID,@PathVariable int amount) {
        try {
            OnGoingOrder onGoingOrder = onGoingOrderService.WorkStationOneFetch(orderID,amount);
            return ResponseEntity.ok().body("Completed");
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
    @PutMapping("/WorkstationOnePass/{orderID}/{amount}")
    public ResponseEntity<?> WorkStationOnePass(@PathVariable String orderID,@PathVariable int amount) {
        try {
            OnGoingOrder onGoingOrder = onGoingOrderService.WorkStationOnePass(orderID,amount);
            return ResponseEntity.ok().body(orderID+ "Completed " +onGoingOrder.toString() );
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + orderID);
        }
    }
    @PutMapping("/WorkstationTwoFetch/{orderID}/{amount}")
    public ResponseEntity<?> WorkStationTwoFetch(@PathVariable String orderID,@PathVariable int amount) {
        try {
            OnGoingOrder onGoingOrder = onGoingOrderService.WorkStationTwoFetch(orderID,amount);
            return ResponseEntity.ok().body(orderID+ "Completed " +onGoingOrder.toString() );
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + orderID);
        }
    }
    @PutMapping("/WorkstationTwoPass/{orderID}/{amount}")
    public ResponseEntity<?> WorkStationTwoPass(@PathVariable String orderID,@PathVariable int amount) {
        try {
            OnGoingOrder onGoingOrder = onGoingOrderService.WorkStationTwoPass(orderID,amount);
            return ResponseEntity.ok().body(orderID+ "Completed " +onGoingOrder.toString() );
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + orderID);
        }
    }
    @PutMapping("/WorkstationThreeFetch/{orderID}/{amount}")
    public ResponseEntity<?> WorkStationThreeFetch(@PathVariable String orderID,@PathVariable int amount) {
        try {
            OnGoingOrder onGoingOrder = onGoingOrderService.WorkStationThreeFetch(orderID,amount);
            return ResponseEntity.ok().body(orderID+ "Completed " +onGoingOrder.toString() );
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + orderID);
        }
    }
    @PutMapping("/WorkstationThreePass/{orderID}/{amount}")
    public ResponseEntity<?> WorkStationThreePass(@PathVariable String orderID,@PathVariable int amount) {
        try {
            OnGoingOrder onGoingOrder = onGoingOrderService.WorkStationThreePass(orderID,amount);
            return ResponseEntity.ok().body(orderID+ "Completed " +onGoingOrder.toString() );
        }
        catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e + orderID);
        }
    }

}
