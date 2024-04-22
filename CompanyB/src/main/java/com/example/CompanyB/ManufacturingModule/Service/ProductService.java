//package com.example.CompanyB.ManufacturingModule.Service;
//
//
//import com.example.CompanyB.ManufacturingModule.Model.Product;
//import com.example.CompanyB.ManufacturingModule.Repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProductService {
//    @Autowired
//    private ProductRepository productRepository;
//
//    public String getReleaseDateById(String id) {
//        Product product = productRepository.getId(id);
//        return product != null ? product.getReleaseDate() : null;
//    }
//}


package com.example.CompanyB.ManufacturingModule.Service;

import com.example.CompanyB.ManufacturingModule.Model.Product;
import com.example.CompanyB.ManufacturingModule.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public String getReleaseDateById(String id) {
        Optional<Product> product = productRepository.findById(id);
        return product.map(Product::getReleaseDate).orElse(null);
    }
}
