package com.example.CompanyB.CustomerOrderMnaagementModule.Service;

import com.example.CompanyB.CustomerOrderMnaagementModule.Model.OrderModel;
import com.example.CompanyB.CustomerOrderMnaagementModule.Repository.OrderRepository;
import com.example.CompanyB.CustomerOrderMnaagementModule.Util.ImageUtils;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Optional;

@Service
public class FileService {

    @Autowired
    private OrderRepository orderRepository;
    

    public String uploadImage(MultipartFile file, String customerId) {
        try {
            Optional<OrderModel> existingOrder = orderRepository.findOrderByCustomerID(customerId);
            if (existingOrder.isPresent()) {
                OrderModel updatedOrder = existingOrder.get();
                updatedOrder.setPcbFile(ImageUtils.compressImage(file.getBytes())); // Assuming ImageUtils is properly implemented
                orderRepository.save(updatedOrder);
                return "File uploaded successfully: " + file.getOriginalFilename();
            } else {
                // Handle case where order is not found for customerId
                return "Order not found for Customer ID: " + customerId;
            }
        } catch (IOException e) {
            // Handle file read/compression errors
            e.printStackTrace();
            return "Failed to upload file: " + e.getMessage();
        } catch (Exception e) {
            // Handle other unexpected errors
            e.printStackTrace();
            return "Internal server error: " + e.getMessage();
        }
    }

    public byte[] downloadImage(String customerId) {
        
        Optional<OrderModel> existingOrder = orderRepository.findOrderByCustomerID(customerId);
        if (existingOrder.isPresent()) {
            OrderModel order = existingOrder.get();
            byte[] dbImageData = order.getPcbFile(); // Assuming getPcbFile() returns byte[]
            return ImageUtils.decompressImage(dbImageData); // Assuming ImageUtils.decompressImage() is properly implemented
        }
        return null;
    }
}