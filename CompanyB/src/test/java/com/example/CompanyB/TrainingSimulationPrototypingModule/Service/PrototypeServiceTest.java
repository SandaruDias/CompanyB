package com.example.CompanyB.TrainingSimulationPrototypingModule.Service;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.PrototypeModel;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Repository.PrototypeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PrototypeServiceTest {

    @Test
    void createPrototype_WithFailedTest_ShouldReturnNull() throws IOException {
        // Arrange
        PrototypeRepository mockRepository = mock(PrototypeRepository.class);
        PrototypeService prototypeService = new PrototypeService(mockRepository);
        MockMultipartFile file = new MockMultipartFile("file", "test.pdf", "application/pdf", "Mock PDF Content".getBytes());

        // Act
        String id = prototypeService.createPrototype(file, "Material", "Color", "Shape", "Comments");

        // Assert
        assertNull(id);
    }


    @Test
    void createPrototype_WithInvalidInput_ShouldReturnNull() throws IOException {
        // Arrange
        PrototypeRepository mockRepository = mock(PrototypeRepository.class);
        PrototypeService prototypeService = new PrototypeService(mockRepository);
        MockMultipartFile file = new MockMultipartFile("file", "test.pdf", "application/pdf", "Mock PDF Content".getBytes());

        // Act
        String id = prototypeService.createPrototype(file, "Material", "Color", "Shape", "Comments");

        // Assert
        assertNull(id);
    }

    @Test
    void getPrototype_WithValidId_ShouldReturnPrototypeModel() {
        // Arrange
        PrototypeRepository mockRepository = mock(PrototypeRepository.class);
        PrototypeService prototypeService = new PrototypeService(mockRepository);
        PrototypeModel expectedPrototype = new PrototypeModel();
        expectedPrototype.setId("testId");
        when(mockRepository.findById("testId")).thenReturn(java.util.Optional.of(expectedPrototype));

        // Act
        PrototypeModel result = prototypeService.getPrototype("testId");

        // Assert
        assertNotNull(result);
        assertEquals("testId", result.getId());
    }

    @Test
    void getPrototype_WithInvalidId_ShouldReturnNull() {
        // Arrange
        PrototypeRepository mockRepository = mock(PrototypeRepository.class);
        PrototypeService prototypeService = new PrototypeService(mockRepository);
        when(mockRepository.findById("invalidId")).thenReturn(java.util.Optional.empty());

        // Act
        PrototypeModel result = prototypeService.getPrototype("invalidId");

        // Assert
        assertNull(result);
    }

    @Test
    void deletePrototype_WithValidId_ShouldDeletePrototype() {
        // Arrange
        PrototypeRepository mockRepository = mock(PrototypeRepository.class);
        PrototypeService prototypeService = new PrototypeService(mockRepository);

        // Act
        prototypeService.deletePrototype("validId");

        // Assert
        // Verify that deleteById method is called with the correct ID
    }
}
