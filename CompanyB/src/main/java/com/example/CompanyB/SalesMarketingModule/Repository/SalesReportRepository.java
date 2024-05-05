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

    // Method to find best-selling products within a given time range
    List<SalesReportModel> findTop3BySaleDateBetweenOrderByQuantitySoldDesc(Date startDate, Date endDate);

    // Method to find slow-moving inventory (products with lowest sales) within a given time range
    List<SalesReportModel> findTop3BySaleDateBetweenOrderByQuantitySoldAsc(Date startDate, Date endDate);

}
