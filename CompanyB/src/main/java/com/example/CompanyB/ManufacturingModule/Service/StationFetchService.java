package com.example.CompanyB.ManufacturingModule.Service;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.OnGoingOrder;
import com.example.CompanyB.ManufacturingModule.Repository.StationFetchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StationFetchService {
    private final StationFetchRepository stationFetchRepository;

    @Autowired
    public StationFetchService(StationFetchRepository stationFetchRepository) {
        this.stationFetchRepository = stationFetchRepository;
    }

    public OnGoingOrder fetchValues(String orderId) {
        // Assuming stationFetchRepository returns OnGoingOrder
        return stationFetchRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
    }
}
