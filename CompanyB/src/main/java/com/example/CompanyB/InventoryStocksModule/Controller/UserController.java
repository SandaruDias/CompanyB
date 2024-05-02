package com.example.CompanyB.InventoryStocksModule.Controller;

import com.example.CompanyB.InventoryStocksModule.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        if (userService.authenticateUser(username, password)) {
            return "redirect:/stock/management";
        } else {
            return "login"; // You can redirect to an error page or show an error message
        }
    }
}


