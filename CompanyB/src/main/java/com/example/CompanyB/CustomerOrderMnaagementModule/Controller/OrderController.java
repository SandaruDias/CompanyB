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

    // Getting order by customer id
    @GetMapping("/{orderID}")
    public ResponseEntity<Optional<OrderModel>> getSingleOrder(@PathVariable Long orderID) {
        return new ResponseEntity<Optional<OrderModel>>(orderService.singleOrder(orderID), HttpStatus.OK);
    }

    // Getting the simulation status
    @GetMapping("/{orderID}/simulation")
    public ResponseEntity<Boolean> getSimulationStatus(@PathVariable Long orderID) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(orderID);
        if (orderOptional.isPresent()) {
            OrderModel order = orderOptional.get();
            boolean simulationStatus = order.isSimulationStatus();
            return new ResponseEntity<>(simulationStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Getting the parts availabilyty
    @GetMapping("/{orderID}/parts")
    public ResponseEntity<Boolean> getPartsAvailability(@PathVariable Long orderID) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(orderID);
        if (orderOptional.isPresent()) {
            OrderModel order = orderOptional.get();
            boolean simulationStatus = order.isPartsAvailable();
            return new ResponseEntity<>(simulationStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Getting the price of the oder
    @GetMapping("/{orderID}/price")
    public ResponseEntity<Double> getPrice(@PathVariable Long orderID) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(orderID);
        if (orderOptional.isPresent()) {
            OrderModel order = orderOptional.get();
            double payment = order.getPayment();
            return new ResponseEntity<>(payment, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Getting the payment status
    @GetMapping("/{orderID}/payment")
    public ResponseEntity<Boolean> getPaymentStatus(@PathVariable Long orderID) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(orderID);
        if (orderOptional.isPresent()) {
            OrderModel order = orderOptional.get();
            boolean paymentDone = order.isPaymentDone();
            return new ResponseEntity<>(paymentDone, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Getting the manufacturing status
    @GetMapping("/{orderID}/manufacturing")
    public ResponseEntity<String> getManufactureStatus(@PathVariable Long orderID) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(orderID);
        if (orderOptional.isPresent()) {
            OrderModel order = orderOptional.get();
            String maufactureDone = order.getManufactureDone();
            return new ResponseEntity<>(maufactureDone, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Getting the delievery address
    @GetMapping("/{orderID}/address")
    public ResponseEntity<String> getAddress(@PathVariable Long orderID) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(orderID);
        if (orderOptional.isPresent()) {
            OrderModel order = orderOptional.get();
            String deliveryAddress = order.getDeliveryAddress();
            return new ResponseEntity<>(deliveryAddress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Getting the delievery status
    @GetMapping("/{orderID}/delivery")
    public ResponseEntity<String> getDeleiveryStatus(@PathVariable Long orderID) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(orderID);
        if (orderOptional.isPresent()) {
            OrderModel order = orderOptional.get();
            String deliveryStatus = order.getDeliveryStatus();
            return new ResponseEntity<>(deliveryStatus, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
     * @PatchMapping("/{customerId}")
     * public OrderModel updateOrder(@PathVariable String customerId, @RequestBody
     * Map<String, Object> fields) {
     * return orderService.updateOrder(customerId, fields);
     * }
     */

    // Updating the simulation status
    @PatchMapping("/{orderID}/setSimulation")
    public ResponseEntity<OrderModel> updateSimulationStatus(@PathVariable Long orderID,
            @RequestBody boolean simulationStatus) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(orderID);
        if (orderOptional.isPresent()) {
            OrderModel orderModel = orderService.updateSimulationStatus(orderID, simulationStatus);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Updating the parts availability
    @PatchMapping("/{orderID}/setParts")
    public ResponseEntity<OrderModel> updatePartsAvailable(@PathVariable Long orderID,
            @RequestBody boolean partsAvailable) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(orderID);
        if (orderOptional.isPresent()) {
            OrderModel orderModel = orderService.updatePartsAvailable(orderID, partsAvailable);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Updating the total price of the order
    @PatchMapping("/{orderID}/setPrice")
    public ResponseEntity<OrderModel> updatePayment(@PathVariable Long orderID, @RequestBody double payment) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(orderID);
        if (orderOptional.isPresent()) {
            OrderModel orderModel = orderService.updatePayment(orderID, payment);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Updating the delivery address
    @PatchMapping("/{orderID}/setAddress")
    public ResponseEntity<OrderModel> updateDeliveryAddress(@PathVariable Long orderID,
            @RequestBody String deliveryAddress) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(orderID);
        if (orderOptional.isPresent()) {
            OrderModel orderModel = orderService.updateDeliveryAddress(orderID, deliveryAddress);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Updating the payment status
    @PatchMapping("/{orderID}/setPayment")
    public ResponseEntity<OrderModel> updatePaymentStatus(@PathVariable Long orderID,
            @RequestBody boolean paymentDone) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(orderID);
        if (orderOptional.isPresent()) {
            OrderModel orderModel = orderService.updatePaymentStaus(orderID, paymentDone);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Updating the manufacturing status
    @PatchMapping("/{orderID}/setManufacturing")
    public ResponseEntity<OrderModel> updateManufactureDone(@PathVariable Long orderID,
            @RequestBody String manufactureDone) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(orderID);
        if (orderOptional.isPresent()) {
            OrderModel orderModel = orderService.updateManufactueDone(orderID, manufactureDone);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Updating the delivery status
    @PatchMapping("/{orderID}/setDelivery")
    public ResponseEntity<OrderModel> updateDeliveryStatus(@PathVariable Long orderID,
            @RequestBody String deliveryStatus) {
        Optional<OrderModel> orderOptional = orderService.singleOrder(orderID);
        if (orderOptional.isPresent()) {
            OrderModel orderModel = orderService.updateDeliveryStatus(orderID, deliveryStatus);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
