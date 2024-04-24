package com.example.CompanyB.CustomerOrderMnaagementModule.Service;

import com.example.CompanyB.CustomerOrderMnaagementModule.Service.FileStorageService;
import com.example.CompanyB.CustomerOrderMnaagementModule.Model.OrderModel;
import com.example.CompanyB.CustomerOrderMnaagementModule.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    FileStorageService file = new FileStorageService();

    public void processDesignApproval(int orderId, FileStorageService designFiles) {
        boolean approvalStatus = simulationSubsystem.evaluateDesign(designFiles);
        OrderModel order = orderRepository.findById(orderId);
        if (approvalStatus) {
            order.setSimulationStatus(true);
            orderRepository.save(order);
        } else {
            // Notify customer for resubmission
            // This could be implemented separately
        }
    }

    public boolean getSimulationStatus(int orderId) {
        OrderModel order = orderRepository.findById(orderId);
        return order != null && order.isSimulationStatus();
    }

}
