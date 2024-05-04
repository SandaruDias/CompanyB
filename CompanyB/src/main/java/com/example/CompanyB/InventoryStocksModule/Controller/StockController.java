package com.example.CompanyB.InventoryStocksModule.Controller;

import com.example.CompanyB.InventoryStocksModule.Service.UserService;
import com.example.CompanyB.InventoryStocksModule.Model.User;
import com.example.CompanyB.InventoryStocksModule.Model.stock;  // Updated entity name
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
@CrossOrigin
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
    public List<stock> generateStockReport(Model model) {
        List<stock> stockList = stockService.getAllStock();  // Updated entity name
        model.addAttribute("stocks", stockList);
        return stockList;
    }

    @GetMapping("/get_suppliers")
    @ResponseBody
    public List<supplier> showAddStockForm(Model model) {
        List<supplier> supplierList = supplierService.getAllSupplier();
        return supplierList;
    }
    
    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<stock> addStock(@RequestBody stock stock, @RequestParam String id) { 
        try {
            stock addedStock = stockService.addStock(stock, id);
            return new ResponseEntity<stock>(addedStock, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/get_stocklist")
    @ResponseBody
    public List<stock> showUpdateStockForm(Model model) {
        List<stock> stockList = stockService.getAllStock(); 
        return stockList;
    }

    @PostMapping("/update")
    @ResponseBody
    
    public ResponseEntity<stock> updateStock(@RequestBody stock stock) {
        try{
            stock updatedStock = stockService.updateStockUnits(stock.getId(), stock.getUnits());
            return new ResponseEntity<stock>(updatedStock, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping("/release")
    @ResponseBody
    public ResponseEntity<stock> releasedStock(@RequestBody stock stock){
        try{
            stock releasedStock=stockService.releasedStockUnits(stock.getId(),stock.getUnits());
            return new ResponseEntity<stock>(releasedStock,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        }
    
    
 

    @PostMapping("/order")
    @ResponseBody
    public OrderDetail addOrder(@RequestBody OrderDetail orderDetail) {  // Updated entity name
        List<stock> stockList = stockService.getAllStock();
        List<supplier> supplierList = supplierService.getAllSupplier();
        orderDetail.product = stockList.stream().filter(stock -> stock.getId().equals(orderDetail.productId)).findFirst().get();  // Updated entity name
        orderDetail.supplier = supplierList.stream().filter(supplier -> supplier.getSuppliername().equals(orderDetail.product.getSuppliername())).findFirst().get();
        OrderDetail newOrder =stockService.addOrder(orderDetail);
        return newOrder;
    }

    @GetMapping("/supplier-of-product") // stock/supplier-of-product?productId=12312312312332
    @ResponseBody
    public stock getSupplierOfProduct_d(@RequestParam String productId) {  // Updated entity name
        List<stock> stockList = stockService.getAllStock();
        
        return stockList.stream().filter(stock -> stock.getId().equals(productId)).findFirst().get();
    }
    

    
}
    
