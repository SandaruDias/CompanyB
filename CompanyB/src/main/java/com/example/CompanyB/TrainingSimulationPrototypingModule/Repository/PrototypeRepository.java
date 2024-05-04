package com.example.CompanyB.TrainingSimulationPrototypingModule.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrototypeRepository extends MongoRepository<PrototypeModel, String> {
}
