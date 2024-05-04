package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.InvoiceCounter;
import com.example.CompanyB.FinancePayRollModule.Repository.InvoiceCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InvoiceCounterService {
    @Autowired
    private InvoiceCounterRepository counterRepository;

    public synchronized int getNextInvoiceId() {
        InvoiceCounter counter = (InvoiceCounter) counterRepository.findById("invoice_counter")
                .orElse(new InvoiceCounter("invoice_counter", 0));

        int nextInvoiceId = counter.getCounterValue() + 1;
        counter.setCounterValue(nextInvoiceId);
        counterRepository.save(counter);
        return nextInvoiceId;
    }
}
