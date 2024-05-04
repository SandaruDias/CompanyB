package com.example.CompanyB.QualityAssuranceModule.Service;


import com.example.CompanyB.QualityAssuranceModule.Model.MarkUpModel;
import com.example.CompanyB.QualityAssuranceModule.Model.Report;
import com.example.CompanyB.QualityAssuranceModule.Repository.MarkUpModelRepository;
import com.example.CompanyB.QualityAssuranceModule.Repository.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkUpModelServiceImpl implements MarkUpModelService {

    @Autowired
    private MarkUpModelRepository markUpModelRepository;

    @Autowired
    private ReportRepository reportRepository;

    public MarkUpModelServiceImpl(MarkUpModelRepository markUpModelRepository) {
        this.markUpModelRepository = markUpModelRepository;
    }

    @Override
    public MarkUpModel createPrototype(MarkUpModel markUpModel) {
        return markUpModelRepository.save(markUpModel);
    }

    @Override
    public List<MarkUpModel> getAllPrototypes() {
        return markUpModelRepository.findAll();
    }

    @Override
    public MarkUpModel getPrototypeById(String id) {
        return markUpModelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Prototype not found with id: " + id));
    }

    @Override
    public Report submitReport(Report report) {
        return reportRepository.save(report);
    }
}