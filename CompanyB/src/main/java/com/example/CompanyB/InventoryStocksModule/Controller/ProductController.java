package com.example.CompanyB.InventoryStocksModule.Controller;

import com.example.CompanyB.InventoryStocksModule.Model.Product;
import com.example.CompanyB.InventoryStocksModule.Service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/product")
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            List<Product> products = productService.getAllProducts();
            if (products.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            logger.error("An error has occurred: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") String id) {
        try {
            return ResponseEntity.ok(productService.getProductById(id));
        } catch (Exception e) {
            logger.error("An error has occurred: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateProduct(@RequestBody Product product) {
        try {
            return ResponseEntity.ok(productService.updateProduct(product));
        } catch (Exception e) {
            logger.error("An error has occurred: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestBody Product product) {
        try {
            return ResponseEntity.ok(productService.deleteProduct(product));
        } catch (Exception e) {
            logger.error("An error has occurred: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/add-units")
    public ResponseEntity<String> addProductUnits(@RequestBody Product product) {
        try {
            return ResponseEntity.ok(productService.addProductUnits(product));
        } catch (Exception e) {
            logger.error("An error has occurred: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/release-product")
    public ResponseEntity<String> releaseProduct(@RequestBody Product product) {
        try {
            return ResponseEntity.ok(productService.releaseProduct(product));
        } catch (Exception e) {
            logger.error("An error has occurred: {}", e.getMessage(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
