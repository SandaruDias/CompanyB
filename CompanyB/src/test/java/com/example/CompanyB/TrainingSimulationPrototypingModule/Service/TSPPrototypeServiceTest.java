package com.example.CompanyB.TrainingSimulationPrototypingModule.Service;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.TSPPrototypeModel;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Repository.TSPPrototypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TSPPrototypeServiceTest {

    @Test
    void createPrototype_WithFailedTest_ShouldReturnNull() throws IOException {
        // Arrange
        TSPPrototypeRepository mockRepository = mock(TSPPrototypeRepository.class);
        TSPPrototypeService TSPPrototypeService = new TSPPrototypeService(mockRepository);
        MockMultipartFile file = new MockMultipartFile("file", "test.pdf", "application/pdf", "Mock PDF Content".getBytes());

        // Act
        String id = TSPPrototypeService.createPrototype(file, "Material", "Color", "Shape", "Comments");

        // Assert
        assertNull(id);
    }

    @Test
    void getPrototype_WithValidId_ShouldReturnTSPPrototypeModel() {
        // Arrange
        TSPPrototypeRepository mockRepository = mock(TSPPrototypeRepository.class);
        TSPPrototypeService TSPPrototypeService = new TSPPrototypeService(mockRepository);
        TSPPrototypeModel expectedPrototype = new TSPPrototypeModel();
        expectedPrototype.setId("testId");
        when(mockRepository.findById("testId")).thenReturn(java.util.Optional.of(expectedPrototype));

        // Act
        TSPPrototypeModel result = TSPPrototypeService.getPrototype("testId");

        // Assert
        assertNotNull(result);
        assertEquals("testId", result.getId());
    }

    @Test
    void getPrototype_WithInvalidId_ShouldReturnNull() {
        // Arrange
        TSPPrototypeRepository mockRepository = mock(TSPPrototypeRepository.class);
        TSPPrototypeService TSPPrototypeService = new TSPPrototypeService(mockRepository);
        when(mockRepository.findById("invalidId")).thenReturn(java.util.Optional.empty());

        // Act
        TSPPrototypeModel result = TSPPrototypeService.getPrototype("invalidId");

        // Assert
        assertNull(result);
    }

    @Test
    void deletePrototype_WithValidId_ShouldDeletePrototype() {
        // Arrange
        TSPPrototypeRepository mockRepository = mock(TSPPrototypeRepository.class);
        TSPPrototypeService TSPPrototypeService = new TSPPrototypeService(mockRepository);

        // Act
        TSPPrototypeService.deletePrototype("validId");

        // Assert
        // Verify that deleteById method is called with the correct ID
    }
}
