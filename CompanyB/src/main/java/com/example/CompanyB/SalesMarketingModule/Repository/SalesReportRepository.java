package com.example.CompanyB.SalesMarketingModule.Repository;

import com.example.CompanyB.SalesMarketingModule.Model.SalesReportModel;
import com.example.CompanyB.SalesMarketingModule.Model.SalesReportModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface SalesReportRepository extends MongoRepository<SalesReportModel, String> {

    List<SalesReportModel> findBySaleDateBetween(Date startDate, Date endDate);
}
