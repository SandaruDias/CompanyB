package com.example.CompanyB;

import com.example.CompanyB.FinancePayRollModule.Model.Payroll;
import com.example.CompanyB.FinancePayRollModule.Repository.PayrollRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Import;

import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataMongoTest
public class PayrollRepositoryTests {

    @Autowired
    private PayrollRepository payrollRepository;

    @Test
    public void testFindByEmployeeId() {
        // Setup data
        Payroll payroll = new Payroll();
        payroll.setEmployeeId(1L);
        payroll.setPayPeriodStart(new Date());
        payroll.setPayPeriodEnd(new Date());
        payroll.setGrossSalary(5000.00);
        payroll.setNetSalary(4500.00);
        payroll.setTaxDeductions(500.00);
        payroll.setPayDate(new Date());
        payroll.setStatus("Processed");

        payrollRepository.save(payroll);

        // Test find by employeeId
        Payroll found = payrollRepository.findByEmployeeId(1L);

        assertThat(found).isNotNull();
        assertThat(found.getEmployeeId()).isEqualTo(1L);
        assertThat(found.getNetSalary()).isEqualTo(4500.00);
    }
}
