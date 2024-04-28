package com.example.CompanyB.CustomerOrderMnaagementModule.Service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CompanyB.CustomerOrderMnaagementModule.Model.OrderModel;
import com.example.CompanyB.CustomerOrderMnaagementModule.Repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    public List<OrderModel> allOrders() {
        return orderRepository.findAll();

    }
    
    public Optional<OrderModel> singleOrder(String customerId) {
        return orderRepository.findOrderByCustomerID(customerId);
    }

}
