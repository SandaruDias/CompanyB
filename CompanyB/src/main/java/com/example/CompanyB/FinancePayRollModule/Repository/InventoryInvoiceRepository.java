package com.example.CompanyB.FinancePayRollModule.Repository;

import com.example.CompanyB.FinancePayRollModule.Model.InventoryInvoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.Date;
import java.util.List;

public interface InventoryInvoiceRepository extends MongoRepository<InventoryInvoice, String> {
    List<InventoryInvoice> findByMaterialName(String materialName);

    List<InventoryInvoice> findByPotentialLossGreaterThan(double threshold);

    List<InventoryInvoice> findByAdjustmentPlanContaining(String keyword);

    List<InventoryInvoice> findByDueDateBetween(Date startDate, Date endDate);

    // Example of a custom query using @Query annotation if more complex queries are needed
    @Query("{ 'materialName' : ?0, 'potentialLoss' : { $gt: ?1 } }")
    List<InventoryInvoice> findHighRiskInvoices(String materialName, double minLoss);


}
