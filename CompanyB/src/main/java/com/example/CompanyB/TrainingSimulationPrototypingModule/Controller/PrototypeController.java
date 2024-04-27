package com.example.CompanyB.TrainingSimulationPrototypingModule.Controller;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.Prototype;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Service.PrototypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prototypes")
public class PrototypeController {

    @Autowired
    private PrototypeService prototypeService;

    @GetMapping("/{id}")
    public ResponseEntity<Prototype> getPrototype(@PathVariable Long id) throws NotFoundException, ChangeSetPersister.NotFoundException {
        Prototype prototype = prototypeService.viewDesignDocument(id);
        if (prototype == null) {
            throw new NotFoundException("Prototype not found with id: " + id);
        }
        return ResponseEntity.ok(prototype);
    }

    @PostMapping
    public ResponseEntity<Prototype> createPrototype(@RequestBody Prototype prototype) {
        Prototype createdPrototype = prototypeService.createPrototype(prototype);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPrototype);
    }

    @PutMapping("/{id}") // Update existing prototype
    public ResponseEntity<Prototype> updatePrototype(@PathVariable Long id, @RequestBody Prototype prototype) throws NotFoundException {
        prototype.setId(id); // Set the ID in the request body (consider validation)
        Prototype updatedPrototype = prototypeService.createPrototype(prototype); // Use createPrototype to update
        if (updatedPrototype == null) {
            throw new NotFoundException("Prototype not found with id: " + id);
        }
        return ResponseEntity.ok(updatedPrototype);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePrototype(@PathVariable Long id) {
        prototypeService.deleteById(id); // Assuming a deleteById method in PrototypeService
        return ResponseEntity.noContent().build();
    }

    private static class NotFoundException extends Exception {
        public NotFoundException(String s) {
        }
    }

    // Implement other methods based on PrototypeService operations (selectMaterials, recordDesignComments, etc.)
    // Use appropriate HTTP methods (POST, PUT, etc.) and handle potential exceptions (NotFoundException, etc.)

}

