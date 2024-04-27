package com.example.CompanyB.TrainingSimulationPrototypingModule.Controller;

import com.example.CompanyB.TrainingSimulationPrototypingModule.DTO.SimTestTO;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.SimTest;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Service.SimulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/simulation")
public class SimulationController
{
    @Autowired
    private SimulService simService;

    @PostMapping("/newSimulation")
    @ResponseStatus(HttpStatus.CREATED)
    public String createSimTest(@RequestBody SimTestTO sim){
        return simService.createSim(sim);
    }

    @GetMapping("/allSimulations")
    @ResponseStatus(HttpStatus.OK)
    public List<SimTest> getAllSims(){
        return simService.getAllSims();
    }

    @GetMapping("/deleteSim")
    @ResponseStatus(HttpStatus.OK)
    public String deleteSimulation(@RequestParam String id){
        return simService.deleteSimulation(id);
    }

    @PutMapping("/updateSimulation")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateSimTest(@RequestBody SimTestTO sim){
        return simService.updateSim(sim);
    }
}
