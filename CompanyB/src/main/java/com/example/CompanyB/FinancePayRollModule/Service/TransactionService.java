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

    public double getCurrentBalance() {
        return transactionRepository.findTopByOrderByTransactionDateDesc()
                .map(Transaction::getBalance)
                .orElse(0.0);
    }

    public void saveTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public Transaction processPayrollTransaction(double amount, String payrollId) {
        double currentBalance = getCurrentBalance();
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(new Date());
        transaction.setExpense(amount);
        transaction.setIncome(0);
        transaction.setBalance(currentBalance - amount);
        transaction.setTransactionType("payroll");
        transaction.setReferenceId(payrollId);
        saveTransaction(transaction);
        return transaction;
    }

    public Transaction processInvoiceTransaction(double amount, String invoiceId) {
        double currentBalance = getCurrentBalance();
        Transaction transaction = new Transaction();
        transaction.setTransactionDate(new Date());
        transaction.setIncome(amount);
        transaction.setExpense(0);
        transaction.setBalance(currentBalance + amount);
        transaction.setTransactionType("invoice");
        transaction.setReferenceId(invoiceId);
        saveTransaction(transaction);
        return transaction;
    }
}
