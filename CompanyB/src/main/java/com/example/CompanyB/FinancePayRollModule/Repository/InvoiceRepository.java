package com.example.CompanyB.FinancePayRollModule.Repository;

import com.example.CompanyB.FinancePayRollModule.Model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InvoiceRepository extends MongoRepository<Invoice, String> {
    List<Invoice> findByCustomerId(String customerId);  // Assuming custom query method
}
