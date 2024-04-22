package com.example.CompanyB.ManufacturingModule.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.CompanyB.ManufacturingModule.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}/release-date")
    public String getReleaseDate(@PathVariable String id) {
        return productService.getReleaseDateById(id);
    }
}
