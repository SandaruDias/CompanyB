package com.example.CompanyB.FinancePayRollModule.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class AlertService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendAlertToDepartments(String message) {
        sendEmail("department@example.com", "Inventory Shortage Alert", message);
    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@example.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
        System.out.println("Email sent to " + to + " with subject: " + subject);
    }
}
