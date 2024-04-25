package com.example.CompanyB.ManufacturingModule.Service;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchOrder;
import com.example.CompanyB.ManufacturingModule.DataTransferObject.OnGoingOrder;
import com.example.CompanyB.ManufacturingModule.Repository.FetchOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchOrderService {

    private final FetchOrderRepository fetchOrderRepository;
    public OnGoingOrder onGoingOrder;     //Initialize the Ongoing Order

    @Autowired
    public FetchOrderService(FetchOrderRepository fetchOrderRepository) {
        this.fetchOrderRepository = fetchOrderRepository;
    }

    public String checkQuantity(String orderId) {
        FetchOrder order = fetchOrderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));
        onGoingOrder.setTotalNumber(order.getQuantity()); //set Order quantity from Order table to Our order

        if (order.getQuantity() == 22) {
            return "YES";
        } else {
            return "NO";
        }
    }
    public String PrintID(String  ID){
        FetchOrder order = fetchOrderRepository.findById(ID)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + ID));
        return order.getId();

    }
}
