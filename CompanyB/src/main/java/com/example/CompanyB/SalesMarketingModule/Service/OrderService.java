package com.example.CompanyB.SalesMarketingModule.Service;

//import com.example.CompanyB.SalesMarketingModule.Model;
import com.example.CompanyB.SalesMarketingModule.Model.OrderModel;
import com.example.CompanyB.SalesMarketingModule.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll();
        //return "hello";

    }
}

