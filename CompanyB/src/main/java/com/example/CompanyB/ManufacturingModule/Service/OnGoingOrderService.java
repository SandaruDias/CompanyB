package com.example.CompanyB.ManufacturingModule.Service;

import com.example.CompanyB.ManufacturingModule.Model.FetchOrder;
import com.example.CompanyB.ManufacturingModule.Model.OnGoingOrder;
import com.example.CompanyB.ManufacturingModule.Model.WorkStationOne;
import com.example.CompanyB.ManufacturingModule.Repository.OnGoingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.BooleanOperators;
import org.springframework.stereotype.Service;

@Service
public class OnGoingOrderService {
    @Autowired
    private OnGoingOrderRepository onGoingOrderRepository;

    public OnGoingOrderService(OnGoingOrderRepository onGoingOrderRepository) {
        this.onGoingOrderRepository = onGoingOrderRepository;
    }

    public int GetCompletedNumber(String OrderId){
        OnGoingOrder Order = onGoingOrderRepository.findById(OrderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + OrderId));
        return  Order.getCompletedNum();

    }
    public boolean SetIsCompleted(String OrderId, boolean IsCompleted){
        OnGoingOrder Order = onGoingOrderRepository.findById(OrderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + OrderId));
        Order.setCompleted(IsCompleted);
        onGoingOrderRepository.save(Order);
        return IsCompleted;
    }

public OnGoingOrder WorkstationOneFetch(String orderId){
        OnGoingOrder order = onGoingOrderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        int success = WorkStationOne.fetch(order,1);
        if(success ==0){
            onGoingOrderRepository.save(order);

        }
        return order;
}
}
