package com.example.CompanyB.QualityAssuranceModule.Repository;



import com.example.CompanyB.QualityAssuranceModule.Model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends MongoRepository<Report, String> {
}