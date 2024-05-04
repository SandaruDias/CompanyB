package com.example.CompanyB.QualityAssuranceModule.Service;


import com.example.CompanyB.QualityAssuranceModule.Model.Prototype;
import com.example.CompanyB.QualityAssuranceModule.Model.Report;
import com.example.CompanyB.QualityAssuranceModule.Repository.PrototypeRepository;
import com.example.CompanyB.QualityAssuranceModule.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrototypeServiceImpl implements PrototypeService {

    @Autowired
    private PrototypeRepository prototypeRepository;

    @Autowired
    private ReportRepository reportRepository;

    public PrototypeServiceImpl(PrototypeRepository prototypeRepository) {
        this.prototypeRepository = prototypeRepository;
    }

    @Override
    public Prototype createPrototype(Prototype prototype) {
        return prototypeRepository.save(prototype);
    }

    @Override
    public List<Prototype> getAllPrototypes() {
        return prototypeRepository.findAll();
    }

    @Override
    public Prototype getPrototypeById(String id) {
        return prototypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prototype not found with id: " + id));
    }

    @Override
    public Report submitReport(Report report) {
        return reportRepository.save(report);
    }
}