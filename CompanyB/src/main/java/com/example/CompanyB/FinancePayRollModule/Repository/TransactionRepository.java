package com.example.CompanyB.FinancePayRollModule.Repository;

import com.example.CompanyB.FinancePayRollModule.Model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

    // Fetch the most recent transaction by descending date order
    Optional<Transaction> findTopByOrderByTransactionDateDesc();

    @Transactional
    @Query(value = "{ 'referenceId' : ?0 }", delete = true)
    void deleteByReferenceId(String referenceId);

    @Query("{'referenceId': ?0}")
    Transaction findByReferenceId(String referenceId);

}
