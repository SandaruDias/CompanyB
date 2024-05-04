package com.example.CompanyB.QualityAssuranceModule.Service;


import com.example.CompanyB.QualityAssuranceModule.Model.Prototype;
import com.example.CompanyB.QualityAssuranceModule.Model.Report;

import java.util.List;

public interface PrototypeService {
    Prototype createPrototype(Prototype prototype);
    List<Prototype> getAllPrototypes();
    Prototype getPrototypeById(String id);
    Report submitReport(Report report);
}