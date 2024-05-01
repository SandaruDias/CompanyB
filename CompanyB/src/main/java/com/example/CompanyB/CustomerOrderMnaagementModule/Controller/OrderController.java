package com.example.CompanyB.CustomerOrderMnaagementModule.Controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.example.CompanyB.CustomerOrderMnaagementModule.Model.OrderModel;
import com.example.CompanyB.CustomerOrderMnaagementModule.Service.OrderService;

@RestController
@RequestMapping("/customer/order")

public class OrderController {

    
    @Autowired
    private OrderService orderService;

    // Creating a new order
    @PostMapping
    public OrderModel addProduct(@RequestBody OrderModel order) {
        return orderService.createOrder(order);
    }

    // Getting all orders
    @GetMapping
    public ResponseEntity<List<OrderModel>> getallOrders() {
        return new ResponseEntity<List<OrderModel>>(orderService.allOrders(), HttpStatus.OK);
    }
    
    //Getting order by customer id
    @GetMapping("/{customerId}")
    public ResponseEntity<Optional<OrderModel>> getSingleOrder(@PathVariable String customerId) {
        return new ResponseEntity<Optional<OrderModel>>(orderService.singleOrder(customerId), HttpStatus.OK);
    }

    //Getting the simulation status
    @GetMapping("/{customerId}/simulation")
    public ResponseEntity<Boolean> getSimulationStatus(@PathVariable String customerId) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(customerId);
        if (orderOptional.isPresent()) {
            OrderModel order = orderOptional.get();
            boolean simulationStatus = order.isSimulationStatus();
            return new ResponseEntity<>(simulationStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Getting the parts availabilyty
    @GetMapping("/{customerId}/parts")
    public ResponseEntity<Boolean> getPartsAvailability(@PathVariable String customerId) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(customerId);
        if (orderOptional.isPresent()) {
            OrderModel order = orderOptional.get();
            boolean simulationStatus = order.isPartsAvailable();
            return new ResponseEntity<>(simulationStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    
    //Getting the price of the oder
    @GetMapping("/{customerId}/price")
    public ResponseEntity<Double> getPrice(@PathVariable String customerId) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(customerId);
        if (orderOptional.isPresent()) {
            OrderModel order = orderOptional.get();
            double payment = order.getPayment();
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Getting the payment status
    @GetMapping("/{customerId}/payment")
    public ResponseEntity<Boolean> getPaymentStatus(@PathVariable String customerId) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(customerId);
        if (orderOptional.isPresent()) {
            OrderModel order = orderOptional.get();
            boolean paymentDone = order.isPaymentDone();
            return new ResponseEntity<>(paymentDone, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    


    // Getting the manufacturing status
    @GetMapping("/{customerId}/manufacturing")
    public ResponseEntity<String> getManufactureStatus(@PathVariable String customerId) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(customerId);
        if (orderOptional.isPresent()) {
            OrderModel order = orderOptional.get();
            String maufactureDone = order.getManufactureDone();
            return new ResponseEntity<>(maufactureDone, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //Getting the delievery address
    @GetMapping("/{customerId}/address")
    public ResponseEntity<String> getAddress(@PathVariable String customerId) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(customerId);
        if (orderOptional.isPresent()) {
            OrderModel order = orderOptional.get();
            String deliveryAddress = order.getDeliveryAddress();
            return new ResponseEntity<>(deliveryAddress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Getting the delievery status
    @GetMapping("/{customerId}/delivery")
    public ResponseEntity<String> getDeleiveryStatus(@PathVariable String customerId) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(customerId);
        if (orderOptional.isPresent()) {
            OrderModel order = orderOptional.get();
            String deliveryStatus = order.getDeliveryStatus();
            return new ResponseEntity<>(deliveryStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    /*@PatchMapping("/{customerId}")
    public OrderModel updateOrder(@PathVariable String customerId, @RequestBody Map<String, Object> fields) {
        return orderService.updateOrder(customerId, fields);
    }*/
    

    // Updating the simulation status
    @PatchMapping("/{customerId}/setSimulation")
    public ResponseEntity<OrderModel> updateSimulationStatus(@PathVariable String customerId, @RequestBody boolean simulationStatus) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(customerId);
        if (orderOptional.isPresent()) {
            OrderModel orderModel = orderService.updateSimulationStatus(customerId, simulationStatus);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Updating the parts availability 
    @PatchMapping("/{customerId}/setParts")
    public ResponseEntity<OrderModel> updatePartsAvailable(@PathVariable String customerId, @RequestBody boolean partsAvailable) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(customerId);
        if (orderOptional.isPresent()) {
            OrderModel orderModel = orderService.updatePartsAvailable(customerId, partsAvailable);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Updating the total price of the order
    @PatchMapping("/{customerId}/setPrice")
    public ResponseEntity<OrderModel> updatePayment(@PathVariable String customerId, @RequestBody double payment) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(customerId);
        if (orderOptional.isPresent()) {
            OrderModel orderModel = orderService.updatePayment(customerId, payment);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Updating the delivery address
    @PatchMapping("/{customerId}/setAddress")
    public ResponseEntity<OrderModel> updateDeliveryAddress(@PathVariable String customerId, @RequestBody String deliveryAddress) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(customerId);
        if (orderOptional.isPresent()) {
            OrderModel orderModel = orderService.updateDeliveryAddress(customerId, deliveryAddress);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Updating the payment status
    @PatchMapping("/{customerId}/setPayment")
    public ResponseEntity<OrderModel> updatePaymentStatus(@PathVariable String customerId, @RequestBody boolean paymentDone) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(customerId);
        if (orderOptional.isPresent()) {
            OrderModel orderModel = orderService.updatePaymentStaus(customerId, paymentDone);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Updating the manufacturing status
    @PatchMapping("/{customerId}/setManufacturing")
    public ResponseEntity<OrderModel> updateManufactureDone(@PathVariable String customerId, @RequestBody String manufactureDone) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(customerId);
        if (orderOptional.isPresent()) {
            OrderModel orderModel = orderService.updateManufactueDone(customerId, manufactureDone);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Updating the delivery status
    @PatchMapping("/{customerId}/setDelivery")
    public ResponseEntity<OrderModel> updateDeliveryStatus(@PathVariable String customerId, @RequestBody String deliveryStatus) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(customerId);
        if (orderOptional.isPresent()) {
            OrderModel orderModel = orderService.updateDeliveryStatus(customerId, deliveryStatus);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
