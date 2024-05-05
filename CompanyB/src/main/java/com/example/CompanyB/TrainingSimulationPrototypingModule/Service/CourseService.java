package com.example.CompanyB.TrainingSimulationPrototypingModule.Service;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.Course;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(String courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        return courseOptional.orElse(null);
    }
}
