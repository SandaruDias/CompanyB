package com.example.CompanyB.TrainingSimulationPrototypingModule.Service;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.Course;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Repository.CourseRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    private static CourseRepository courseRepository = null;

    public CourseService(CourseRepository courseRepository) {
        CourseService.courseRepository = courseRepository;
    }

    public static Course getCourseBySkillLevel(int skillLevel) {
        return courseRepository.findBySkillLevelLessThanEqual(skillLevel);
    }

}
