package com.example.CompanyB.InventoryStocksModule.Controller;

import com.example.CompanyB.InventoryStocksModule.Repository.SupplierDao;
import com.example.CompanyB.InventoryStocksModule.Model.supplier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.CompanyB.InventoryStocksModule.Service.SupplierService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;



@Controller
@CrossOrigin
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierDao supplierDao;
    
    @Autowired
    SupplierService supplierService;

    @GetMapping("/report")
    @ResponseBody
    public List<supplier> generateSupplierReport(Model model) {
        List<supplier> supplierList = supplierService.getAllSupplier(); 
        model.addAttribute( "supplier", supplierList);
        return supplierList;
    }
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<supplier> addSupplier(@RequestBody supplier supplier) { 
        try {
            supplier addedSupplier = supplierService.addSupplier(supplier);
            return new ResponseEntity<supplier>(addedSupplier, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
