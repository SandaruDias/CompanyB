package com.example.CompanyB.FinancePayRollModule.Service;

import org.springframework.stereotype.Service;

@Service
public class AlertService {
    public void sendAlertToDepartments(String message) {
        // Implement email or messaging system integration here
        System.out.println("Sending alert: " + message);
    }
}
