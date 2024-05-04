package com.example.CompanyB.FinancePayRollModule.Repository;

import com.example.CompanyB.FinancePayRollModule.Model.SalesNotification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SalesNotificationRepository extends MongoRepository<SalesNotification, String> {
    // Additional custom queries can be defined here, if necessary
}
