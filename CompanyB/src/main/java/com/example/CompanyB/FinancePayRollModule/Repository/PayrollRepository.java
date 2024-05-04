//package com.example.CompanyB.FinancePayRollModule.Repository;
//
//import com.example.CompanyB.FinancePayRollModule.Model.Payroll;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
//
//@Repository
//public interface PayrollRepository extends MongoRepository<Payroll, String> {
//    Page<Payroll> findByEmployeeId(Long employeeId, Pageable pageable);
//}
package com.example.CompanyB.FinancePayRollModule.Repository;

import com.example.CompanyB.FinancePayRollModule.Model.EmployeePayroll;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PayrollRepository extends MongoRepository<EmployeePayroll, String> {
    List<EmployeePayroll> findByEmployeeId(String employeeId);
}
