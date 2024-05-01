package com.example.CompanyB.CustomerOrderMnaagementModule.Service;


import java.lang.reflect.Field;
import java.util.List;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import com.example.CompanyB.CustomerOrderMnaagementModule.Model.OrderModel;
import com.example.CompanyB.CustomerOrderMnaagementModule.Repository.OrderRepository;


@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    //Getting the all orders
    public List<OrderModel> allOrders() {
        return orderRepository.findAll();

    }
    //Getting the order by customer id
    public Optional<OrderModel> singleOrder(String customerId) {
        return orderRepository.findOrderByCustomerID(customerId);
    }

    // Creating a new order
    public OrderModel createOrder(OrderModel order) {
        return orderRepository.save(order);
    }
    
    // Updating the order status
    public OrderModel updateOrderStatus(OrderModel existingOrder) {
        if (existingOrder.isPaymentDone()== true) {
            System.out.println("Order is confirmed");
            existingOrder.setManufactureDone("In Progress");
        } else {
            existingOrder.setManufactureDone(null);
        }
        if (existingOrder.getManufactureDone()== "Completed") {
            System.out.println("Order is ready");
            existingOrder.setDeliveryStatus("Shipped");
        } else {
            existingOrder.setDeliveryStatus(null);
        }


        return existingOrder;
        
    }

    /*@SuppressWarnings("null")
    public OrderModel updateOrder(String customerID, Map<String, Object> fields) {
        Optional<OrderModel> existingOrder = orderRepository.findOrderByCustomerID(customerID);
        if (existingOrder.isPresent()) {
            fields.forEach((key, value) -> {
                Field field = ReflectionUtils.findField(OrderModel.class, key);
                field.setAccessible(true);
                ReflectionUtils.setField(field, existingOrder.get(), value);
            });
            if (existingOrder.get().isSimulationStatus() && existingOrder.get().isPartsAvailable() == true) {
                System.out.println("Order is confirmed");
                existingOrder.get().setConfirmation(true);
                existingOrder.get().setManufactureDone("Processing");
            } else {
                existingOrder.get().setConfirmation(false);
                existingOrder.get().setManufactureDone(null);
            }
            return orderRepository.save(existingOrder.get());
        }
        return null;
    }*/

    // Updating the simaualtion staus
    //@SuppressWarnings("null")
    public OrderModel updateSimulationStatus(String customerID, Boolean simulationStatus) {
        Optional<OrderModel> existingOrder = orderRepository.findOrderByCustomerID(customerID);
        if (existingOrder.isPresent()) {
            Field field = ReflectionUtils.findField(OrderModel.class, "simulationStatus");
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingOrder.get(), simulationStatus);
            return orderRepository.save(existingOrder.get());
        }

        return null;
    }

    // Updating the availability of the parts 
    //@SuppressWarnings("null")
    public OrderModel updatePartsAvailable(String customerID, Boolean partsAvailable) {
        Optional<OrderModel> existingOrder = orderRepository.findOrderByCustomerID(customerID);
        if (existingOrder.isPresent()) {
            Field field = ReflectionUtils.findField(OrderModel.class, "partsAvailable");
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingOrder.get(), partsAvailable);
            return orderRepository.save(existingOrder.get());
        }

        return null;
    }


    // Updating the total price of the order
   // @SuppressWarnings("null")
    public OrderModel updatePayment(String customerID, double payment) {
        Optional<OrderModel> existingOrder = orderRepository.findOrderByCustomerID(customerID);
        if (existingOrder.isPresent()) {
            Field field = ReflectionUtils.findField(OrderModel.class, "payment");
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingOrder.get(), payment);
            return orderRepository.save(existingOrder.get());
        }

        return null;
    }

    // Updating the delivery address
    //@SuppressWarnings("null")
    public OrderModel updateDeliveryAddress(String customerID, String deliveryAddress) {
        Optional<OrderModel> existingOrder = orderRepository.findOrderByCustomerID(customerID);
        if (existingOrder.isPresent()) {
            Field field = ReflectionUtils.findField(OrderModel.class, "deliveryAddress");
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingOrder.get(), deliveryAddress);
            return orderRepository.save(existingOrder.get());
        }

        return null;
    }


    // Updating the payment status
    //@SuppressWarnings("null")
    public OrderModel updatePaymentStaus(String customerID, Boolean paymentDone) {
        Optional<OrderModel> existingOrder = orderRepository.findOrderByCustomerID(customerID);
        if (existingOrder.isPresent()) {
            Field field = ReflectionUtils.findField(OrderModel.class, "paymentDone");
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingOrder.get(), paymentDone);
            if (existingOrder.get().isPaymentDone() == true) {
                System.out.println("Order is confirmed");
                existingOrder.get().setManufactureDone("In Progress");
            }
            return orderRepository.save(existingOrder.get());
        }

        return null;
    }

    
    

    // Updating the manufacturing status
    //@SuppressWarnings("null")
    public OrderModel updateManufactueDone(String customerID, String maufactureDone) {
        Optional<OrderModel> existingOrder = orderRepository.findOrderByCustomerID(customerID);
        if (existingOrder.isPresent()) {
            Field field = ReflectionUtils.findField(OrderModel.class, "manufactureDone");
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingOrder.get(), maufactureDone);
            if (existingOrder.get().getManufactureDone().equals("Completed")) {
                System.out.println("Order is ready");
                existingOrder.get().setDeliveryStatus("Shipped");
            }
            return orderRepository.save(existingOrder.get());
        }
        return null;
    }

    // Updating the delivery status
    //@SuppressWarnings("null")
    public OrderModel updateDeliveryStatus(String customerID, String deliveryStatus) {
        Optional<OrderModel> existingOrder = orderRepository.findOrderByCustomerID(customerID);
        if (existingOrder.isPresent()) {
            Field field = ReflectionUtils.findField(OrderModel.class, "deliveryStatus");
            field.setAccessible(true);
            ReflectionUtils.setField(field, existingOrder.get(), deliveryStatus);
            return orderRepository.save(existingOrder.get());
        }

        return null;
    }
    

}
