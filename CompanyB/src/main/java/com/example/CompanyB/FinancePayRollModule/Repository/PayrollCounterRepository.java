package com.example.CompanyB.FinancePayRollModule.Repository;

import com.example.CompanyB.FinancePayRollModule.Model.PayrollCounter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PayrollCounterRepository extends MongoRepository<PayrollCounter, String> {
}
