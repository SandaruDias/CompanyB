package com.example.CompanyB.FinancePayRollModule.Repository;

import com.example.CompanyB.FinancePayRollModule.Model.InventoryInvoice;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InventoryInvoiceRepository extends MongoRepository<InventoryInvoice, String> {
    // Custom database queries can be added here
}
