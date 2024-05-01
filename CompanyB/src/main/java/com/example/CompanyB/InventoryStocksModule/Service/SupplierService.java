package com.example.CompanyB.InventoryStocksModule.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CompanyB.InventoryStocksModule.Repository.SupplierDao;
import com.example.CompanyB.InventoryStocksModule.Model.supplier;
import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierDao supplierDao;
    public List<supplier> getAllSupplier() {
        return supplierDao.findAllWithDetails(); 
}
    public supplier addSupplier(supplier supplier) {
        supplier newSupplier = supplierDao.save(supplier);
        return newSupplier;
}}

