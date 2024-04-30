package com.example.CompanyB.ManufacturingModule.Service;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchOrder;
import com.example.CompanyB.ManufacturingModule.DataTransferObject.OnGoingOrder;
import com.example.CompanyB.ManufacturingModule.Repository.FetchOrderRepository;
import com.example.CompanyB.ManufacturingModule.Repository.OnGoingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FetchOrderService {

    private final FetchOrderRepository fetchOrderRepository;
    private final OnGoingOrderRepository onGoingOrderRepository;

    @Autowired
    public FetchOrderService(FetchOrderRepository fetchOrderRepository, OnGoingOrderRepository onGoingOrderRepository) {
        this.fetchOrderRepository = fetchOrderRepository;
        this.onGoingOrderRepository = onGoingOrderRepository;
    }

    public String checkQuantity(String orderId) {
        FetchOrder order = fetchOrderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        if (order.getQuantity() == 22) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public OnGoingOrder fetchOrderFromOrderDetails(String orderId) {
        FetchOrder fetchOrder = fetchOrderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        OnGoingOrder onGoingOrder = new OnGoingOrder(orderId);
        onGoingOrder.setTotalNumber(fetchOrder.getQuantity());
        onGoingOrder.setWaitToOne(fetchOrder.getQuantity());
        onGoingOrderRepository.insert(onGoingOrder); // assuming save is the correct method if insert doesn't exist.
        onGoingOrderRepository.save(onGoingOrder);
        return onGoingOrder;
    }

    public String printID(String ID) {
        FetchOrder order = fetchOrderRepository.findById(ID)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + ID));
        return order.getId();
    }
}
