package com.example.CompanyB.SalesMarketingModule.Repository;

import com.example.CompanyB.SalesMarketingModule.Model.SalesAnalysisModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface SalesAnalysisRepository extends MongoRepository<SalesAnalysisModel, String> {

    List<SalesAnalysisModel> findBySaleDateBetween(Date startDate, Date endDate);

    List<SalesAnalysisModel> findTop3BySaleDateBetweenOrderByQuantityDesc(Date startDate, Date endDate);

    List<SalesAnalysisModel> findTop3BySaleDateBetweenOrderByQuantityAsc(Date startDate, Date endDate);

}
