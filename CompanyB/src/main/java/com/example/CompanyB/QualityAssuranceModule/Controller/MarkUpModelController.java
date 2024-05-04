package com.example.CompanyB.QualityAssuranceModule.Controller;



import com.example.CompanyB.QualityAssuranceModule.Model.MarkUpModel;
import com.example.CompanyB.QualityAssuranceModule.Model.Report;
import com.example.CompanyB.QualityAssuranceModule.Service.MarkUpModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class MarkUpModelController {

    @Autowired
    private MarkUpModelService markUpModelService;
    private MarkUpModel MarkUpModel;

    @PostMapping("/prototypes")
    public <prototype extends MarkUpModel> ResponseEntity<prototype> createPrototype(@Valid @RequestBody prototype prototype) {
        prototype createdPrototype = (prototype) markUpModelService.createPrototype(prototype);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPrototype);
    }

    @GetMapping("/prototypes")
    public ResponseEntity<List<MarkUpModel>> getAllPrototypes() {
        List<MarkUpModel> markUpModels = markUpModelService.getAllPrototypes();
        return ResponseEntity.ok().body(markUpModels);
    }

    @GetMapping("/prototypes/{id}")
    public ResponseEntity<MarkUpModel> getPrototypeById(@PathVariable("id") String id) {
        MarkUpModel markUpModel = markUpModelService.getPrototypeById(id);
        return ResponseEntity.ok().body(markUpModel);
    }

    @PostMapping("/reports")
    public ResponseEntity<Report> submitReport(@Valid @RequestBody Report report) {
        Report submittedReport = markUpModelService.submitReport(report);
        return ResponseEntity.status(HttpStatus.CREATED).body(submittedReport);
    }
}