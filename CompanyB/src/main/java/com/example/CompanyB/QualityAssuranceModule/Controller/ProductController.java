package com.example.CompanyB.QualityAssuranceModule.Controller;

import com.example.CompanyB.QualityAssuranceModule.Repository.ProductRepository;
import org.springframework.web.bind.annotation.RestController;

import com.example.CompanyB.QualityAssuranceModule.Model.Product;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/products")

public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping()
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

}

