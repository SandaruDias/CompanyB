package com.example.CompanyB.TrainingSimulationPrototypingModule.Controller;

import com.example.CompanyB.TrainingSimulationPrototypingModule.Model.PrototypeModel;
import com.example.CompanyB.TrainingSimulationPrototypingModule.Service.PrototypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

class PrototypeControllerTest {

    @Mock
    private PrototypeService prototypeService;

    private PrototypeController prototypeController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        prototypeController = new PrototypeController(prototypeService);
    }

    @Test
    void createPrototype_Success() throws IOException {
        // Mock data
        String prototypeId = "12345";
        MultipartFile file = mock(MultipartFile.class);
        when(prototypeService.createPrototype(any(MultipartFile.class), anyString(), anyString(), anyString(), anyString())).thenReturn(prototypeId);

        // Call controller method
        ResponseEntity<String> response = prototypeController.createPrototype(file, "material", "color", "shape", "comments");

        // Verify response
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(prototypeId, response.getBody());
    }



    @Test
    void getPrototype_Exists() {
        // Mock data
        String prototypeId = "12345";
        PrototypeModel prototypeModel = new PrototypeModel();
        prototypeModel.setId(prototypeId);
        when(prototypeService.getPrototype(anyString())).thenReturn(prototypeModel);

        // Call controller method
        ResponseEntity<PrototypeModel> response = prototypeController.getPrototype(prototypeId);

        // Verify response
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(prototypeModel, response.getBody());
    }

    @Test
    void getPrototype_NotExists() {
        // Mock scenario where prototype does not exist
        when(prototypeService.getPrototype(anyString())).thenReturn(null);

        // Call controller method
        ResponseEntity<PrototypeModel> response = prototypeController.getPrototype("nonexistentId");

        // Verify response
        assertNotNull(response);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    @Test
    void deletePrototype_Success() {
        // Mock successful deletion
        doNothing().when(prototypeService).deletePrototype(anyString());

        // Call controller method
        ResponseEntity<Void> response = prototypeController.deletePrototype("12345");

        // Verify response
        assertNotNull(response);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    @Test
    void deletePrototype_Failure() {
        // Mock deletion failure
        doThrow(new RuntimeException()).when(prototypeService).deletePrototype(anyString());

        // Call controller method
        ResponseEntity<Void> response = prototypeController.deletePrototype("12345");

        // Verify response
        assertNotNull(response);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
