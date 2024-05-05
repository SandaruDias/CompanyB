package com.example.CompanyB.TrainingSimulationPrototypingModule.Service;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.TSPPrototypeModel;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Repository.TSPPrototypeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TSPPrototypeService {


    private final TSPPrototypeRepository TSPPrototypeRepository;

    public TSPPrototypeService(TSPPrototypeRepository TSPPrototypeRepository) {
        this.TSPPrototypeRepository = TSPPrototypeRepository;
    }

    @Transactional
    public String createPrototype(MultipartFile file, String material, String color, String shape, String comments) throws IOException {
        TSPPrototypeModel prototype = new TSPPrototypeModel();
        prototype.setDesignDocumentPdf(file.getBytes());
        prototype.setMaterial(material);
        prototype.setColor(color);
        prototype.setShape(shape);
        prototype.setComments(comments);

        // Save the prototype in the database
        TSPPrototypeModel savedPrototype = TSPPrototypeRepository.save(prototype);
        return savedPrototype.getId();
    }
    public List<TSPPrototypeModel> getAllPrototypes() {
        List<TSPPrototypeModel> prototypeList = new ArrayList<>();
        try {
            prototypeList = TSPPrototypeRepository.findAll();
        } catch (Exception ignored) {

        }
        return prototypeList;
    }
    @Transactional
    public void updatePrototype(String id, boolean thermalTestPassed, boolean electricalTestPassed, boolean approvalStatus, String approvalMessage) {
        TSPPrototypeModel prototype = TSPPrototypeRepository.findById(id).orElse(null);
        if (prototype != null) {
            prototype.setThermalTestPassed(thermalTestPassed);
            prototype.setElectricalTestPassed(electricalTestPassed);
            prototype.setApprovalStatus(approvalStatus);
            prototype.setApprovalMessage(approvalMessage);
            TSPPrototypeRepository.save(prototype);
        }
    }
    public TSPPrototypeModel getPrototype(String id) {
        return TSPPrototypeRepository.findById(id).orElse(null);
    }
    public void deletePrototype(String id) {
        TSPPrototypeRepository.deleteById(id);
    }
}

