package com.example.CompanyB.TrainingSimulationPrototypingModule.Repository;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.Prototype;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PrototypeRepository extends MongoRepository<Prototype, Long> {

    Optional<Prototype> findById(Long id);
}
