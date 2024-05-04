package com.example.CompanyB.FinancePayRollModule.Repository;

import com.example.CompanyB.FinancePayRollModule.Model.InvoiceCounter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface InvoiceCounterRepository extends MongoRepository<InvoiceCounter, String> {
}
