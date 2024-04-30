package com.example.CompanyB.FinancePayRollModule.Repository;

import com.example.CompanyB.FinancePayRollModule.Model.PaymentTransaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PaymentTransactionRepository extends MongoRepository<PaymentTransaction, String> {
    List<PaymentTransaction> findByInvoiceId(String invoiceId);
    List<PaymentTransaction> findByCustomerId(String customerId);
}
