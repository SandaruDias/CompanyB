package com.example.CompanyB.TrainingSimulationPrototypingModule.Service;

import com.example.CompanyB.TrainingSimulationPrototypingModule.DTO.SimTestTO;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.SimTest;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Repository.SimulationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class SimulServiceTest {

    @Mock
    private SimulationRepository simRepo;

    @InjectMocks
    private SimulService simulService;

    @Test
    void createSim() {
        // Mock data using builder pattern
        SimTestTO simTestTO = SimTestTO.builder()
                .testID("testID")
                .simulApproval(true)
                .simulComments("comments")
                .circuitSimulStatus(true)
                .thermalSimulStatus(true)
                .manufacturabilityStatus(true)
                .build();

        // Mock repository
        when(simRepo.save(any(SimTest.class))).thenReturn(new SimTest());

        // Test service method
        String result = simulService.createSim(simTestTO);

        // Verify repository method was called
        verify(simRepo, times(1)).save(any(SimTest.class));

        // Assert result
        assertEquals("New Simulation added successfully.", result);
    }





    @Test
    void getAllSims() {
        // Mock data
        List<SimTest> simList = new ArrayList<>();
        simList.add(new SimTest());

        // Mock repository
        when(simRepo.findAll()).thenReturn(simList);

        // Test service method
        List<SimTest> result = simulService.getAllSims();

        // Verify repository method was called
        verify(simRepo, times(1)).findAll();

        // Assert result
        assertEquals(1, result.size());
    }

    @Test
    void deleteSimulation() {
        // Mock repository
        doNothing().when(simRepo).deleteById("123");

        // Test service method
        String result = simulService.deleteSimulation("123");

        // Verify repository method was called
        verify(simRepo, times(1)).deleteById("123");

        // Assert result
        assertEquals("Simulation deleted successfully", result);
    }


}
