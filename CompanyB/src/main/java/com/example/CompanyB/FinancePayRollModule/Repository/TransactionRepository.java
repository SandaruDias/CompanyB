package com.example.CompanyB.FinancePayRollModule.Repository;

import com.example.CompanyB.FinancePayRollModule.Model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import java.util.Optional;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

    // Fetch the most recent transaction by descending date order
    @Query(value = "{}", sort = "{ 'transactionDate' : -1 }")
    Optional<Transaction> findTopByOrderByTransactionDateDesc();
}
