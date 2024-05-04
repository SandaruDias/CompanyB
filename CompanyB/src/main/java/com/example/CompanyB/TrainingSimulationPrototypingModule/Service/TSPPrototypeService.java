package com.example.CompanyB.TrainingSimulationPrototypingModule.Service;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.TSPPrototypeModel;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Repository.TSPPrototypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class TSPPrototypeService {


    private final TSPPrototypeRepository TSPPrototypeRepository;

    public TSPPrototypeService(TSPPrototypeRepository TSPPrototypeRepository) {
        this.TSPPrototypeRepository = TSPPrototypeRepository;
    }

    public String createPrototype(MultipartFile file, String material, String color, String shape, String comments, boolean thermalTestPassed, boolean electricalTestPassed) throws IOException {
        TSPPrototypeModel prototype = new TSPPrototypeModel();
        prototype.setDesignDocumentPdf(file.getBytes());
        prototype.setMaterial(material);
        prototype.setColor(color);
        prototype.setShape(shape);
        prototype.setComments(comments);
        prototype.setThermalTestPassed(thermalTestPassed);
        prototype.setElectricalTestPassed(electricalTestPassed);

        // Determine approval status and message
        String approvalStatus;
        String approvalMessage;
        if (thermalTestPassed && electricalTestPassed) {
            approvalStatus = "Pass";
            approvalMessage = "Prototype approved.";
        } else {
            approvalStatus = "Fail";
            approvalMessage = "Prototype failed due to testing issues.";
        }
        prototype.setApprovalStatus(approvalStatus);
        prototype.setApprovalMessage(approvalMessage);

        // Save the prototype only if both tests pass
        if (thermalTestPassed && electricalTestPassed) {
            TSPPrototypeModel savedPrototype = TSPPrototypeRepository.save(prototype);
            return savedPrototype.getId();
        } else {
            return null; // Return null to indicate rejection
        }
    }
    public TSPPrototypeModel getPrototype(String id) {
        return TSPPrototypeRepository.findById(id).orElse(null);
    }
    public void deletePrototype(String id) {
        TSPPrototypeRepository.deleteById(id);
    }
}

