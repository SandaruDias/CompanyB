package com.example.CompanyB.TrainingSimulationPrototypingModule.Controller;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.TPSEmployee;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Service.TPSEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class TPSEmployeeController {
    private final TPSEmployeeService TPSEmployeeService;

    @Autowired
    public TPSEmployeeController(TPSEmployeeService TPSEmployeeService) {
        this.TPSEmployeeService = TPSEmployeeService;
    }

    @PostMapping("/add")
    public TPSEmployee addEmployee(@RequestBody TPSEmployee TPSEmployee) {
        return TPSEmployeeService.addEmployee(TPSEmployee);
    }

    @GetMapping("/get/{employeeId}")
    public TPSEmployee getEmployeeById(@PathVariable String employeeId) {
        return TPSEmployeeService.getEmployeeById(employeeId);
    }

    @PostMapping("/selectCourse/{employeeId}/{courseId}")
    public void selectCourseForEmployee(
            @PathVariable String employeeId,
            @PathVariable String courseId
    ) {
        TPSEmployeeService.selectCourseForEmployee(employeeId, courseId);
    }
}
