package com.example.CompanyB.TrainingSimulationPrototypingModule.Repository;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {
    //Course findBySkillLevelLessThanEqual(int skillLevel);
}
