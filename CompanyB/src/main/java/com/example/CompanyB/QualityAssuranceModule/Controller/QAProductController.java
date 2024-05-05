package com.example.CompanyB.QualityAssuranceModule.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.CompanyB.QualityAssuranceModule.Model.QAProduct;
import com.example.CompanyB.QualityAssuranceModule.Repository.QAProductRepository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/products")

public class QAProductController {
    @Autowired
    private QAProductRepository QAProductRepository;

    @GetMapping()
    public List<QAProduct> getAllProducts(){
        return QAProductRepository.findAll();
    }

}

