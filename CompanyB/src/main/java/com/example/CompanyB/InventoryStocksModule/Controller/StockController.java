package com.example.CompanyB.InventoryStocksModule.Controller;

import com.example.CompanyB.InventoryStocksModule.Service.UserService;
import com.example.CompanyB.InventoryStocksModule.Model.User;
import com.example.CompanyB.InventoryStocksModule.Model.stock1;  // Updated entity name
import com.example.CompanyB.InventoryStocksModule.Service.StockService;
import com.example.CompanyB.InventoryStocksModule.Model.OrderDetail;
import com.example.CompanyB.InventoryStocksModule.Model.supplier;
import com.example.CompanyB.InventoryStocksModule.Service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;



import java.util.stream.Collectors;


@Controller
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @Autowired
    SupplierService supplierService;

    @Autowired
    UserService userService;

    @GetMapping("/management")
    public String displayGenerateReportPage() {
        return "stockManagement";
    }

    @GetMapping("/report")
    @ResponseBody
    public List<stock1> generateStockReport(Model model) {
        List<stock1> stockList = stockService.getAllStock();  // Updated entity name
        model.addAttribute("stocks", stockList);
        return stockList;
    }

    @GetMapping("/add")
    public List<supplier> showAddStockForm(Model model) {
        List<supplier> supplierList = supplierService.getAllSupplier();
        return supplierList;
    }
    
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<stock1> addStock(@RequestBody stock1 stock, @RequestParam String id) { 
        try {
            stock1 addedStock = stockService.addStock(stock, id);
            return new ResponseEntity<stock1>(addedStock, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/update")
    public List<stock1> showUpdateStockForm(Model model) {
        List<stock1> stockList = stockService.getAllStock(); 
        return stockList;
    }

    @PostMapping("/update")
    
    public ResponseEntity<stock1> updateStock(@RequestBody stock1 stock) {
        try{
            stock1 updatedStock = stockService.updateStockUnits(stock.getId(), stock.getUnits());
            return new ResponseEntity<stock1>(updatedStock, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/order")
    public List<stock1> showOrderlist(Model model) {
        List<stock1> stockList = stockService.getAllStock();
        return stockList;
    }

    @PostMapping("/order")
    public OrderDetail addOrder(OrderDetail orderDetail) {  // Updated entity name
        List<stock1> stockList = stockService.getAllStock();
        orderDetail.product = stockList.stream().filter(stock -> stock.getId().equals(orderDetail.productId)).findFirst().get();  // Updated entity name
        
        OrderDetail newOrder =stockService.addOrder(orderDetail);
        return newOrder;
    }

    @GetMapping("/supplier-of-product") // stock/supplier-of-product?productId=12312312312332
    @ResponseBody
    public stock1 getSupplierOfProduct_d(@RequestParam String productId) {  // Updated entity name
        List<stock1> stockList = stockService.getAllStock();
        
        return stockList.stream().filter(stock -> stock.getId().equals(productId)).findFirst().get();
    }
    

    
}
    
