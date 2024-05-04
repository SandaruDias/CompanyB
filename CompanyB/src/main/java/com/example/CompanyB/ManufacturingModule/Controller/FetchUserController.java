package com.example.CompanyB.ManufacturingModule.Controller;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchUser;
import com.example.CompanyB.ManufacturingModule.Service.FetchUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/FetchUser")
public class FetchUserController {

    private final FetchUserService fetchUserService;

    @Autowired
    public FetchUserController(FetchUserService fetchUserService) {
        this.fetchUserService = fetchUserService;
    }

    @GetMapping("/users/{userName}")
    public String findUserByUserName(@PathVariable String userName) {
        FetchUser user = fetchUserService.findByUserName(userName);
        if (user!= null) {
            return user.toString();
        } else {
            return "User not found";
        }
    }
}