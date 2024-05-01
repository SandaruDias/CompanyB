package com.example.CompanyB.InventoryStocksModule.Service.Impl;

import com.example.CompanyB.InventoryStocksModule.Model.Product;
import com.example.CompanyB.InventoryStocksModule.Repository.ProductRepository;
import com.example.CompanyB.InventoryStocksModule.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        //return all products
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(String id) {
        //return product by ID if no match return null
        return productRepository.findById(id).orElse(null);
    }

}
