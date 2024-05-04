package com.example.CompanyB.HumanResourceManagementModule.Repository;

import com.example.CompanyB.HumanResourceManagementModule.Model.TotalHoursWorkedModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TotalHoursWorkedRepo extends MongoRepository<TotalHoursWorkedModel, String> {
}
