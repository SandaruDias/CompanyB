package com.example.CompanyB.ManufacturingModule.Service;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchOrder;
import com.example.CompanyB.ManufacturingModule.DataTransferObject.OnGoingOrder;
import com.example.CompanyB.ManufacturingModule.Repository.FetchOrderRepository;
import com.example.CompanyB.ManufacturingModule.Repository.OnGoingOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchOrderService {

    private final FetchOrderRepository fetchOrderRepository;
    private final OnGoingOrderRepository onGoingOrderRepository;


    @Autowired
    public FetchOrderService(FetchOrderRepository fetchOrderRepository, OnGoingOrderRepository onGoingOrderRepository) {
        this.fetchOrderRepository = fetchOrderRepository;
        this.onGoingOrderRepository = onGoingOrderRepository;
    }


    public OnGoingOrder SetQuantityOfOngoingOrder(String orderId) {
        FetchOrder order = fetchOrderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Not found with id: " + orderId));

        OnGoingOrder onGoingOrder=new OnGoingOrder(orderId);
//                onGoingOrderRepository.findById(orderId).orElseThrow(() -> new RuntimeException("Not found with id: " + orderId));

        onGoingOrder.setTotalNumber(order.getQuantity()); //set Order quantity from Order table to Our order
        onGoingOrder.setWaitToOne(order.getQuantity()); //set Wait to one to Order Quantity
        onGoingOrderRepository.insert(onGoingOrder);
        onGoingOrderRepository.save(onGoingOrder);
        fetchOrderRepository.save(order);

        return  onGoingOrder;
    }



}
