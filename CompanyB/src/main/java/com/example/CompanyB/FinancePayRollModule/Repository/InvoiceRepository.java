package com.example.CompanyB.FinancePayRollModule.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.CompanyB.FinancePayRollModule.Model.Invoice;  // Adjust the import path if necessary

public interface InvoiceRepository extends MongoRepository<Invoice, String> {
}
