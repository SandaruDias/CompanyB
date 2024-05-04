package com.example.CompanyB.TrainingSimulationPrototypingModule.Repository;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.SimTest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SimulationRepository extends MongoRepository<SimTest, String>
{

}

/* SimulationRepository inherits methods from MongoRepository */