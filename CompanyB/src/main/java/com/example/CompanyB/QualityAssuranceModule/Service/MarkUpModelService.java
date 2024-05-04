package com.example.CompanyB.QualityAssuranceModule.Service;


import com.example.CompanyB.QualityAssuranceModule.Model.MarkUpModel;
import com.example.CompanyB.QualityAssuranceModule.Model.Report;

import java.util.List;

public interface MarkUpModelService {
    MarkUpModel createPrototype(MarkUpModel markUpModel);
    List<MarkUpModel> getAllPrototypes();
    MarkUpModel getPrototypeById(String id);
    Report submitReport(Report report);
}