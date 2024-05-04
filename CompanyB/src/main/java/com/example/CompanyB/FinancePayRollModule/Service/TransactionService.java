package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.Transaction;
import com.example.CompanyB.FinancePayRollModule.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public void processPayrollTransaction(double amount) {
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(new Date());
        transaction.setBalance(-amount); // Deduct from the balance
        transaction.setTransactionMethod("payroll");
        saveTransaction(transaction);
    }

    public void processInvoiceTransaction(double amount) {
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(new Date());
        transaction.setBalance(amount); // Add to the balance
        transaction.setTransactionMethod("invoice");
        saveTransaction(transaction);
    }
}
