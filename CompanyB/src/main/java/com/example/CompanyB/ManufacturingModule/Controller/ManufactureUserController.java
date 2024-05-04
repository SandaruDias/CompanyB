package com.example.CompanyB.ManufacturingModule.Controller;

import com.example.CompanyB.ManufacturingModule.Service.UserControllingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/User")

public class ManufactureUserController {
    private final UserControllingService userControllingService;

    public ManufactureUserController(UserControllingService userControllingService) {
        this.userControllingService = userControllingService;
    }

    @PutMapping("adminLogin/{username}/{password}")
    public ResponseEntity<?> adminLogin(@PathVariable String username, @PathVariable String password) {
        try {
            int result = userControllingService.loginAdmin(username, password);
            if (result == 0) {
                return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
            } else if (result == -1) {
                return ResponseEntity.status(HttpStatus.OK).body("You Dont Have access");
            } else if (result == -2) {
                return ResponseEntity.status(HttpStatus.OK).body("Incorrect Password");
            } else {
                return ResponseEntity.status(HttpStatus.OK).body("User name is incorrect");
            }

        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }

    }

    @PutMapping("workstationLogin/{workstationId}/{username}/{password}")
    public ResponseEntity<?> workstationLogin(@PathVariable int workstationId,@PathVariable String username,@PathVariable String password){
        try{
            int result = userControllingService.loginWorkstation(workstationId,username,password);
            if(result == 0){
                return ResponseEntity.status(HttpStatus.OK).body("Login Successful");
            }
            else if (result ==-1) {
                return ResponseEntity.status(HttpStatus.OK).body("Can't log this workstation now");
            }
            else if(result ==-2){
                return ResponseEntity.status(HttpStatus.OK).body("Password is incorrect");
            }
            else{
                return ResponseEntity.status(HttpStatus.OK).body("Username is wrong");
            }
        }
        catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
    @PutMapping("workStation/signout/{workStationId}")
    public ResponseEntity<?> signOut(@PathVariable int workStationId){
        try{
            int result = userControllingService.signOut(workStationId);
            if (result ==0){
                return ResponseEntity.status(HttpStatus.OK).body("Signed Out");
            }
            else{
                return ResponseEntity.status(HttpStatus.OK).body("error");
            }
        }
        catch(Exception e){
            return ResponseEntity.status(HttpStatus.OK).body(e);
        }
    }
}