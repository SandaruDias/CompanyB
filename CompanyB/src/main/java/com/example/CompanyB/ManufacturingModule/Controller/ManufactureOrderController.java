package com.example.CompanyB.ManufacturingModule.Controller;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.OnGoingOrder;
import com.example.CompanyB.ManufacturingModule.Service.ManufactureOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/Orders")
public class ManufactureOrderController {

    private final ManufactureOrderService manufactureOrderService;

    @Autowired
    public ManufactureOrderController(ManufactureOrderService manufactureOrderService) {
        this.manufactureOrderService = manufactureOrderService;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<?> checkQuantity(@PathVariable String orderId) {
        try {
            OnGoingOrder onGoingOrder = manufactureOrderService.AssignOrderDetails(orderId);
            return ResponseEntity.ok().body(onGoingOrder.getTotalNumber() +" No of items have in the order no of "+ onGoingOrder.getId()+"wait to one"+onGoingOrder.getWaitToOne());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Order not found with ID: " + orderId);
        }
    }
}
