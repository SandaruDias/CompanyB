package com.example.CompanyB.SalesMarketingModule.Service;

import com.example.CompanyB.SalesMarketingModule.Model.InventoryItem;
import com.example.CompanyB.SalesMarketingModule.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<InventoryItem> getAllInventoryItems() {
        return inventoryRepository.findAll();
    }
}
