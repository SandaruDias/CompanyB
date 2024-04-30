package com.example.CompanyB.FinancePayRollModule.Repository;

import com.example.CompanyB.FinancePayRollModule.Model.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;
import java.util.Date;

public interface InvoiceRepository extends MongoRepository<Invoice, String> {
    List<Invoice> findByCustomerIdAndDueDateBetween(String customerId, Date start, Date end);
    List<Invoice> findByStatus(Boolean status);
}
