package com.example.CompanyB.SalesMarketingModule.Service;

//import com.example.CompanyB.SalesMarketingModule.Model;
import com.example.CompanyB.SalesMarketingModule.Model.InventoryItem;
import com.example.CompanyB.SalesMarketingModule.Model.OrderItem;
import com.example.CompanyB.SalesMarketingModule.Model.SalesOrderModel;
import com.example.CompanyB.SalesMarketingModule.Repository.InventoryRepository;
import com.example.CompanyB.SalesMarketingModule.Repository.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SalesOrderService {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<SalesOrderModel> getAllOrders() {
        return salesOrderRepository.findAll();
        //return "hello";

    }
    public SalesOrderModel checkStockAvailability(SalesOrderModel order) {
        boolean allItemsGoodToGo = true; // Flag to track if all items have enough stock

        List<OrderItem> orderItems = order.getItems();
        for (OrderItem orderItem : orderItems) {
            String itemId = orderItem.getItem_id();
            int orderedQuantity = orderItem.getQuantity();
            InventoryItem inventoryItem = inventoryRepository.findByItem_id(itemId);
            if (inventoryItem != null) {
                int availableQuantity = inventoryItem.getQuantity_available();
                if (orderedQuantity <= availableQuantity) {
                    orderItem.setStock_status("Enough");
                } else {
                    orderItem.setStock_status("Not Enough");
                    allItemsGoodToGo = false; // At least one item doesn't have enough stock
                }
            } else {
                // Handle case where inventory item is not found
                orderItem.setStock_status("Not Found");
                allItemsGoodToGo = false; // At least one item not found
            }
        }
        // Update order status based on stock availability
        if (allItemsGoodToGo) {
            order.setStatus("Good to go");
        } else {
            order.setStatus("Bad request");
        }

        return order;
    }
    public SalesOrderModel fetchOrderDetails(String orderId) {
        // Implement the logic to fetch order details by orderId from the database
        return salesOrderRepository.findById(orderId).orElse(null);
    }
}

