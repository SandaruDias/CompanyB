package com.example.CompanyB.TrainingSimulationPrototypingModule.Controller;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.Prototype;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Service.PrototypeService;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tps/prototypes")
public class PrototypeController {

    private final PrototypeService prototypeService;

    public PrototypeController(PrototypeService prototypeService) {
        this.prototypeService = prototypeService;
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Prototype> getPrototype(@PathVariable Long id) throws NotFoundException, ChangeSetPersister.NotFoundException {
        Prototype prototype = prototypeService.viewDesignDocument(id);
        if (prototype == null) {
            throw new NotFoundException();
        }
        return ResponseEntity.ok(prototype);
    }

    @PostMapping("/create")
    private ResponseEntity<Prototype> createPrototype(@RequestBody Prototype prototype) {
        Prototype createdPrototype = prototypeService.createPrototype(prototype);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPrototype);
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

    public static class NotFoundException extends Exception {
        public NotFoundException() { // Renamed parameter for clarity
        }
    }

    @PutMapping("/{id}/reject")
    public ResponseEntity<String> rejectDesign(@PathVariable Long id, @RequestBody String message) throws Exception {
        prototypeService.rejectFailedDesign(message, id);
        return ResponseEntity.ok("Design rejected successfully!");
    }

    @PutMapping("/{id}/materials")
    public ResponseEntity<String> updateMaterials(@PathVariable Long id, @RequestBody String materials) throws Exception {
        String response = prototypeService.selectMaterials(materials, id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}/comments")
    public ResponseEntity<String> recordComments(@PathVariable Long id, @RequestBody String comments) throws Exception {
        String response = prototypeService.recordDesignComments(comments, id);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/shape")
    public ResponseEntity<String> getShape(@PathVariable Long id) throws Exception {
        String shape = prototypeService.getDesignShape(id);
        return ResponseEntity.ok(shape);
    }

    @GetMapping("/{id}/color")
    public ResponseEntity<String> getColor(@PathVariable Long id) throws Exception {
        String color = prototypeService.getDesignColor(id);
        return ResponseEntity.ok(color);
    }


}

