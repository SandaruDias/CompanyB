package com.example.CompanyB.QualityAssuranceModule.Controller;



import com.example.CompanyB.QualityAssuranceModule.Model.Prototype;
import com.example.CompanyB.QualityAssuranceModule.Model.Report;
import com.example.CompanyB.QualityAssuranceModule.Service.PrototypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PrototypeController {

    @Autowired
    private PrototypeService prototypeService;
    private com.example.CompanyB.QualityAssuranceModule.Model.Prototype Prototype;

    @PostMapping("/prototypes")
    public <prototype extends Prototype> ResponseEntity<prototype> createPrototype(@Valid @RequestBody prototype prototype) {
        prototype createdPrototype = (prototype) prototypeService.createPrototype(prototype);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPrototype);
    }

    @GetMapping("/prototypes")
    public ResponseEntity<List<Prototype>> getAllPrototypes() {
        List<Prototype> prototypes = prototypeService.getAllPrototypes();
        return ResponseEntity.ok().body(prototypes);
    }

    @GetMapping("/prototypes/{id}")
    public ResponseEntity<Prototype> getPrototypeById(@PathVariable("id") String id) {
        Prototype prototype = prototypeService.getPrototypeById(id);
        return ResponseEntity.ok().body(prototype);
    }

    @PostMapping("/reports")
    public ResponseEntity<Report> submitReport(@Valid @RequestBody Report report) {
        Report submittedReport = prototypeService.submitReport(report);
        return ResponseEntity.status(HttpStatus.CREATED).body(submittedReport);
    }
}