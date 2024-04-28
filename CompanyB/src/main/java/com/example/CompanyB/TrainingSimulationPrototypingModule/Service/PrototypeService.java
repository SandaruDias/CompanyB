package com.example.CompanyB.TrainingSimulationPrototypingModule.Service;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.Prototype;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Repository.PrototypeRepository;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class PrototypeService {


    private final PrototypeRepository prototypeRepository;

    public PrototypeService(PrototypeRepository prototypeRepository) {
        this.prototypeRepository = prototypeRepository;
    }

    public Prototype viewDesignDocument(Long id) throws ChangeSetPersister.NotFoundException {
        return prototypeRepository.findById(id)
                .orElseThrow(ChangeSetPersister.NotFoundException::new); // Use NotFoundException
    }

    public Prototype createPrototype(Prototype prototype) {
        return prototypeRepository.save(prototype);
    }


    public void rejectFailedDesign(String message, Long prototypeId) throws Exception {
        Prototype prototype = prototypeRepository.findById(prototypeId)
                .orElseThrow(() -> new Exception("Prototype not found with id: " + prototypeId));

        prototype.setRejected(true);
        prototype.setRejectionMessage(message);
        prototypeRepository.save(prototype);
    }

    public void deleteById(Long id) {
        prototypeRepository.deleteById(id);
    }
    public String selectMaterials(String materials, Long prototypeId) throws Exception {
        Prototype prototype = prototypeRepository.findById(prototypeId)
                .orElseThrow(() -> new Exception("Prototype not found with id: " + prototypeId));
        prototype.setMaterials(materials);
        prototypeRepository.save(prototype);
        return "Materials selection saved successfully!";
    }

    public String recordDesignComments(String comments, Long prototypeId) throws Exception {
        Prototype prototype = prototypeRepository.findById(prototypeId)
                .orElseThrow(() -> new Exception("Prototype not found with id: " + prototypeId));
        prototype.setComments(comments);
        prototypeRepository.save(prototype);
        return "Design comments recorded!";
    }

    public String getDesignShape(Long prototypeId) throws Exception {
        Prototype prototype = prototypeRepository.findById(prototypeId)
                .orElseThrow(() -> new Exception("Prototype not found with id: " + prototypeId));
        return prototype.getShape();
    }

    public String getDesignColor(Long prototypeId) throws Exception {
        Prototype prototype = prototypeRepository.findById(prototypeId)
                .orElseThrow(() -> new Exception("Prototype not found with id: " + prototypeId));
        return prototype.getColor();
    }
}