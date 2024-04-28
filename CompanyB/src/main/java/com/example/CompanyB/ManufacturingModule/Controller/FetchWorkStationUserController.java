package com.example.CompanyB.ManufacturingModule.Controller;

import com.example.CompanyB.ManufacturingModule.DataTransferObject.FetchWorksStationUser;
import com.example.CompanyB.ManufacturingModule.Service.FetchWorkStationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Orders")
public class FetchWorkStationUserController {


    private final FetchWorkStationUserService fetchWorksStationUserService;

    @Autowired
    public FetchWorkStationUserController(FetchWorkStationUserService fetchWorksStationUserService) {
        this.fetchWorksStationUserService = fetchWorksStationUserService;
    }

    @GetMapping("/workstation/{workStationId}")
    public ResponseEntity<?> getWorkStationById(@PathVariable Integer workStationId) {
        try {
            FetchWorksStationUser user = fetchWorksStationUserService.GetWorkstationDocument(workStationId);
            return ResponseEntity.ok().body(user.toString());
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e);
        }
    }
}