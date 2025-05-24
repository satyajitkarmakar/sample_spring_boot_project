package com.example.controllers;

import com.example.dtos.IncidentTypeDTO;
import com.example.services.IncidentTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Satyajit Karmakar
 * This class represents Rest API endpoints for Incident type resource
 */
@RestController
@RequestMapping("/api/incident-type")
@CrossOrigin("http://localhost:4200/")
@Tag(name="Incident Type Endpoint")
@RequiredArgsConstructor
public class IncidentTypeController {
    private final IncidentTypeService incidentTypeService;

    /**
     * GET method for retrieving all the incident types.
     * @return ResponseEntity with a list of all incident types if successful,
     * or an error response if an exception occurs during the retrieval process.
     */
    @GetMapping
    @Operation(summary = "Returns all the incident type that are present")
    public ResponseEntity<List<IncidentTypeDTO>> findAllIncidentTypes(){
        List<IncidentTypeDTO> incidentTypeList  = incidentTypeService.getAllIncidentTypes();
        return ResponseEntity.ok(incidentTypeList);
    }
}
