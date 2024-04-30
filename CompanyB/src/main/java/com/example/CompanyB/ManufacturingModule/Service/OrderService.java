package com.example.CompanyB.ManufacturingModule.Service;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchOrder;
import com.example.CompanyB.ManufacturingModule.DataTransferObject.OnGoingOrder;
import com.example.CompanyB.ManufacturingModule.Repository.FetchOrderRepository;
import com.example.CompanyB.ManufacturingModule.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final FetchOrderRepository fetchOrderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, FetchOrderRepository fetchOrderRepository) {
        this.orderRepository = orderRepository;
        this.fetchOrderRepository = fetchOrderRepository;
    }

    public OnGoingOrder AssignOrderDetails(String orderId) {


//        FetchOrderService fetchOrderService = new FetchOrderService(fetchOrderRepository);

        FetchOrder fetchOrder = fetchOrderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

//        String testflag = fetchOrderService.checkQuantity(orderId);
        OnGoingOrder onGoingOrder = new OnGoingOrder(orderId);
        onGoingOrder.setId(fetchOrder.getId());
        onGoingOrder.setTotalNumber(fetchOrder.getQuantity());
        onGoingOrder.setWaitToOne(fetchOrder.getQuantity());
//        System.out.println(testflag);

        return onGoingOrder;
    }
}
