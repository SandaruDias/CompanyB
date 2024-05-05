package com.example.CompanyB.TrainingSimulationPrototypingModule.Controller;

import com.example.CompanyB.TrainingSimulationPrototypingModule.DTO.SimTestTO;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Service.SimulService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class SimulationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SimulService simService;

    @Test
    void createSimTest() throws Exception {
        // Mock SimTestTO object
        SimTestTO simTestTO = SimTestTO.builder()
                .testID("123456")
                .simulApproval(true)
                .simulComments("Test comments")
                .circuitSimulStatus(true)
                .thermalSimulStatus(false)
                .manufacturabilityStatus(true)
                .build();

        // Mock service response
        when(simService.createSim(any(SimTestTO.class))).thenReturn("Simulation created successfully");

        // Perform POST request and verify the response
        mockMvc.perform(MockMvcRequestBuilders.post("/tps/simulations/new")
                        .content(asJsonString(simTestTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }



    @Test
    void deleteSimulation() throws Exception {
        // Mock service response
        when(simService.deleteSimulation("testId")).thenReturn("Simulation deleted successfully");

        // Perform DELETE request and verify the response
        mockMvc.perform(MockMvcRequestBuilders.get("/tps/simulations/delete?id=testId")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void updateSimTest() throws Exception {
        // Mock SimTestTO object
        SimTestTO simTestTO = SimTestTO.builder()
                .testID("123456")
                .simulApproval(true)
                .simulComments("Updated comments")
                .circuitSimulStatus(false)
                .thermalSimulStatus(true)
                .manufacturabilityStatus(false)
                .build();

        // Mock service response
        when(simService.updateSim(any(SimTestTO.class))).thenReturn("Simulation updated successfully");

        // Perform PUT request and verify the response
        mockMvc.perform(MockMvcRequestBuilders.put("/tps/simulations/update")
                        .content(asJsonString(simTestTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    // Utility method to convert object to JSON string
    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
