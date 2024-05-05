package com.example.CompanyB.TrainingSimulationPrototypingModule.Controller;

import com.example.CompanyB.TrainingSimulationPrototypingModule.DTO.SimTestTO;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.SimTest;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Service.SimulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tps/simulations")
public class SimulationController
{
    @Autowired
    private SimulService simService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public String createSimTest(@RequestBody SimTestTO sim){
        return simService.createSim(sim);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<SimTest> getAllSims(){
        return simService.getAllSims();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public SimTest getSim(@PathVariable String id){
        return simService.getSim(id);
    }

    @GetMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public String deleteSimulation(@RequestParam String id){
        return simService.deleteSimulation(id);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public String updateSimTest(@RequestBody SimTestTO sim){
        return simService.updateSim(sim);
    }
}
