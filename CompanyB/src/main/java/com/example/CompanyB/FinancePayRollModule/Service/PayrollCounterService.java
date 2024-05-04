package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.PayrollCounter;
import com.example.CompanyB.FinancePayRollModule.Repository.PayrollCounterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayrollCounterService {
    @Autowired
    private PayrollCounterRepository counterRepository;

    public synchronized int getNextPayrollId() {
        PayrollCounter counter = (PayrollCounter) counterRepository.findById("payroll_counter")
                .orElse(new PayrollCounter("payroll_counter", 0));

        int nextInvoiceId = counter.getCounterValue() + 1;
        counter.setCounterValue(nextInvoiceId);
        counterRepository.save(counter);
        return nextInvoiceId;
    }
}
