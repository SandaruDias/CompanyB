package com.example.CompanyB.InventoryStocksModule.Service;

import com.example.CompanyB.InventoryStocksModule.Model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    Product getProductById(String id);

    String updateProduct(Product product);
}
