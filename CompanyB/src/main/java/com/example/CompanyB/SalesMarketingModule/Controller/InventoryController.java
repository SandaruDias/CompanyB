package com.example.CompanyB.SalesMarketingModule.Controller;

import com.example.CompanyB.SalesMarketingModule.Model.InventoryItem;
import com.example.CompanyB.SalesMarketingModule.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/allInventory")
    public List<InventoryItem> getAllInventoryItems(Model model) {
        return inventoryService.getAllInventoryItems();
    }
}
