package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.EmployeePayroll;
import com.example.CompanyB.FinancePayRollModule.Model.Invoice;
import com.example.CompanyB.FinancePayRollModule.Model.Transaction;
import com.example.CompanyB.FinancePayRollModule.Repository.TransactionRepository;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public List<Transaction> getAllTransactionDetails() {
        return transactionRepository.findAll();
    }


    public byte[] generateExcelReportForTransactions(List<Transaction> transactions) throws IOException {
        try (XSSFWorkbook workbook = new XSSFWorkbook(); ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Transactions");

            String[] columns = {"Transaction ID", "Income", "Expense", "Balance", "Transaction Date", "Transacrion Type", "Reference ID"};
            Row headerRow = sheet.createRow(0);
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            int rowNum = 1;
            for (Transaction transaction : transactions) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(transaction.getTransactionId());
                row.createCell(1).setCellValue(transaction.getIncome());
                row.createCell(2).setCellValue(transaction.getExpense());
                row.createCell(3).setCellValue(transaction.getBalance());
                row.createCell(4).setCellValue(transaction.getTransactionDate());
                row.createCell(5).setCellValue(transaction.getTransactionType());
                row.createCell(6).setCellValue(transaction.getReferenceId());
            }

            for (int i = 0; i < columns.length; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(bos);
            return bos.toByteArray();
        }
    }


    public Transaction getTransactionByReferenceId(String referenceId) {
        // Return the transaction if found or an empty Optional if not
        return transactionRepository.findByReferenceId(referenceId);
    }
}
