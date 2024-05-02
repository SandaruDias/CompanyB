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

    @Override
    public String updateProduct(Product product) {

        //get matching product by ID
        Product matchingProduct = productRepository.findProductById(product.getId());
        if (matchingProduct == null) {
            return "Invalid Product Id!";
        }
        //Set values to matching product
        matchingProduct.setName(product.getName());
        matchingProduct.setDescription(product.getDescription());
        matchingProduct.setUnits(product.getUnits());
        matchingProduct.setUpdatedDate(LocalDateTime.now());

        //save
        productRepository.save(matchingProduct);
        return "Product has been successfully updated!";
    }

    @Override
    public String deleteProduct(Product product) {
        //delete product by ID
        productRepository.deleteById(product.getId());
        return "Product has been successfully deleted!";
    }

}
