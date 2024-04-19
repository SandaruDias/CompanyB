package com.example.CompanyB.FinancePayRollModule.Repository;

import com.example.CompanyB.FinancePayRollModule.Model.Payroll;
        import org.springframework.data.mongodb.repository.MongoRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface PayrollRepository extends MongoRepository<Payroll, String> {
    // Define custom methods here if needed, e.g., findByEmployeeId
    Payroll findByEmployeeId(Long employeeId);
}