package com.example.CompanyB.TrainingSimulationPrototypingModule.Service;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.PrototypeModel;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Repository.PrototypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class PrototypeService {

    private final PrototypeRepository prototypeRepository;

    public PrototypeService(PrototypeRepository prototypeRepository) {
        this.prototypeRepository = prototypeRepository;
    }

    @Transactional
    public String createPrototype(MultipartFile file, String material, String color, String shape, String comments) throws IOException {
        PrototypeModel prototype = new PrototypeModel();
        prototype.setDesignDocumentPdf(file.getBytes());
        prototype.setMaterial(material);
        prototype.setColor(color);
        prototype.setShape(shape);
        prototype.setComments(comments);

        // Save the prototype in the database
        PrototypeModel savedPrototype = prototypeRepository.save(prototype);
        return savedPrototype.getId();
    }

    @Transactional
    public void updatePrototype(String id, boolean thermalTestPassed, boolean electricalTestPassed, String approvalStatus, String approvalMessage) {
        PrototypeModel prototype = prototypeRepository.findById(id).orElse(null);
        if (prototype != null) {
            prototype.setThermalTestPassed(thermalTestPassed);
            prototype.setElectricalTestPassed(electricalTestPassed);
            prototype.setApprovalStatus(approvalStatus);
            prototype.setApprovalMessage(approvalMessage);
            prototypeRepository.save(prototype);
        }
    }

    public PrototypeModel getPrototype(String id) {
        return prototypeRepository.findById(id).orElse(null);
    }

    public void deletePrototype(String id) {
        prototypeRepository.deleteById(id);
    }
}
