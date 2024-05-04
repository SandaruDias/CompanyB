package com.example.CompanyB.FinancePayRollModule.Service;

import com.example.CompanyB.FinancePayRollModule.Model.Employee;
import com.example.CompanyB.FinancePayRollModule.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }
}
