package com.example.CompanyB.TrainingSimulationPrototypingModule.Service;

import com.example.CompanyB.TrainingSimulationPrototypingModule.DTO.SimTestTO;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.SimTest;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Repository.SimulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SimulService {
    @Autowired
    private SimulationRepository simRepo;

    public String createSim(SimTestTO simTestTO) {
        try {
            SimTest sim = SimTest.builder()
                    .testID(simTestTO.getTestID())// no need to give test ID
                    .designDoc(simTestTO.getDesignDoc())
                    .simulApproval(simTestTO.isSimulApproval())
                    .simulComments(simTestTO.getSimulComments())
                    .circuitSimulStatus(simTestTO.isCircuitSimulStatus())
                    .thermalSimulStatus(simTestTO.isThermalSimulStatus())
                    .manufacturabilityStatus(simTestTO.isManufacturabilityStatus()).build();
            SimTest savedSim = simRepo.save(sim);
            return savedSim.getTestID(); // Return the MongoDB ID
        } catch (Exception e) {
            // Handle exception
            return null; // or throw an exception
        }
    }
    /* Create new simulation in the database*/
    public List<SimTest> getAllSims() {
        List<SimTest> simList = new ArrayList<>();
        try {
            simList = simRepo.findAll();
        } catch (Exception e) {
            //Write your exception
        }
        return simList;
    }
    /* Get all simulations as a list */

    public SimTest getSim(String id) {
        Optional<SimTest> optionalSim = simRepo.findById(id);
        return optionalSim.orElse(null); // Return the simulation or null if not found
    }
    public String deleteSimulation(@RequestParam String id) {
        try {
            simRepo.deleteById(id);
        } catch (Exception e) {
            //Write your exception
        }
        return "Simulation deleted successfully";
    }/* Delete a simulation */

    public String updateSim(SimTestTO sim) {
        try {
            SimTest simulation = SimTest.builder()
                    .testID(sim.getTestID())
                    .simulApproval(sim.isSimulApproval())
                    .simulComments(sim.getSimulComments())
                    .circuitSimulStatus(sim.isCircuitSimulStatus())
                    .thermalSimulStatus(sim.isThermalSimulStatus())
                    .manufacturabilityStatus(sim.isManufacturabilityStatus())
                    .build();
            simRepo.save(simulation);
        }
        catch(Exception e){
            //
        }
        return "Simulation updated successfully ";
    }/* Update simulation */
}
