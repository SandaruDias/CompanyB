package com.example.CompanyB.ManufacturingModule.Controller;

import com.example.CompanyB.ManufacturingModule.Model.OnGoingOrder;
import com.example.CompanyB.ManufacturingModule.Service.StationFetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/StationFetch")
public class StationFetchController {

    private final StationFetchService stationFetchService;

    @Autowired
    public StationFetchController(StationFetchService stationFetchService) {
        this.stationFetchService = stationFetchService;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OnGoingOrder> fetchValues(@PathVariable String orderId) {
        try {
            OnGoingOrder onGoingOrder = stationFetchService.fetchValues(orderId);
            return ResponseEntity.ok().body(onGoingOrder);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
