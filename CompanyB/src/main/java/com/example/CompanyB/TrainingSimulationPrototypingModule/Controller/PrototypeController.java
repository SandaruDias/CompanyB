package com.example.CompanyB.TrainingSimulationPrototypingModule.Controller;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.PrototypeModel;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Service.PrototypeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/tps/prototypes")
public class PrototypeController {


    private final PrototypeService prototypeService;

    public PrototypeController(PrototypeService prototypeService) {
        this.prototypeService = prototypeService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPrototype(@RequestParam("file") MultipartFile file,
                                                  @RequestParam("material") String material,
                                                  @RequestParam("color") String color,
                                                  @RequestParam("shape") String shape,
                                                  @RequestParam("comments") String comments, boolean thermalTestPassed, boolean electricalTestPassed) {
        try {
            String prototypeId = prototypeService.createPrototype(file, material, color, shape, comments, thermalTestPassed, electricalTestPassed);
            return ResponseEntity.ok(prototypeId);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create prototype.");
        }


    @PutMapping("/update/{id}") // Update existing prototype
    public ResponseEntity<Prototype> updatePrototype(@PathVariable Long id, @RequestBody Prototype prototype) throws NotFoundException {
        prototype.setId(id); // Set the ID in the request body (consider validation)
        Prototype updatedPrototype = prototypeService.createPrototype(prototype); // Use createPrototype to update
        if (updatedPrototype == null) {
            throw new NotFoundException();
        }
        return ResponseEntity.ok(updatedPrototype);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePrototype(@PathVariable Long id) {
        prototypeService.deleteById(id); // Assuming a deleteById method in PrototypeService
        return ResponseEntity.noContent().build();
    }

    @GetMapping("get/{id}")
    public ResponseEntity<PrototypeModel> getPrototype(@PathVariable String id) {
        try {
            PrototypeModel prototype = prototypeService.getPrototype(id);
            if (prototype != null) {
                return ResponseEntity.ok(prototype);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
