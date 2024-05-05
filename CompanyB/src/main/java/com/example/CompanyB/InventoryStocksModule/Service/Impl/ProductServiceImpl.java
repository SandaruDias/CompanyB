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
    public Product addProduct(Product product) {
        //set timestamp
        product.setCreatedDate(LocalDateTime.now());
        product.setUpdatedDate(LocalDateTime.now());
        //save
        return productRepository.insert(product);
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

    @Override
    public String addProductUnits(Product product) {

        if (product.getUnits() > 0) {
            //get matching product by ID
            Product matchingProduct = productRepository.findProductById(product.getId());
            if (matchingProduct == null) {
                return "Invalid Product Id!";
            }
            //set unit to variable
            int units = matchingProduct.getUnits() + product.getUnits();
            //set new unit to matching object
            matchingProduct.setUnits(units);
            //update timestamp
            matchingProduct.setUpdatedDate(LocalDateTime.now());
            //save product object with new units
            productRepository.save(matchingProduct);

            return product.getUnits() + " units has been successfully added! " + units + " units available now.";

        } else {
            return "Invalid Unit Count. Please enter positive numbers!";
        }
    }


    @Override
    public String releaseProduct(Product product) {

        //check is positive number
        if (product.getUnits() > 0) {

            //filter matching product by ID
            Product matchingProduct = productRepository.findProductById(product.getId());
            if (matchingProduct == null) {
                return "Invalid Product Id!";
            }

            //get unit count form matching record
            int units = matchingProduct.getUnits();

            if (units > 0 && units >= product.getUnits()) {
                //set new unit to matching object
                matchingProduct.setUnits(units - product.getUnits());
                //update timestamp
                matchingProduct.setUpdatedDate(LocalDateTime.now());
                //save product object with new units
                productRepository.save(matchingProduct);

                return product.getUnits() + " units has been released! Only " + matchingProduct.getUnits() + " units left.";
            }
            return "Product is not available. Only " + units + " units left.";
        } else {
            return "Invalid Unit Count. Please enter positive numbers!";
        }
    }

}
