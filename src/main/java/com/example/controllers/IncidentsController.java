package com.example.controllers;

import com.example.dtos.IncidentRequest;
import com.example.dtos.IncidentResponse;
import com.example.dtos.IncidentsDTO;
import com.example.dtos.InvestigationReportDTO;
import com.example.services.IncidentsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Satyajit Karmakar
 * This class represents Rest API endpoints for Incident resource
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
@Tag(name="Incident Endpoint")
public class IncidentsController {
    private final IncidentsService incidentsService;

    /**
     * POST method for creating a new incident.
     * @param incidentRequest data transfer object containing data for the new incident.
     * @return ResponseEntity with a success message containing the Incident ID if creation is successful,
     * or an error message if an exception occurs during the creation process.
     */
    @PostMapping("/incidents/report")
    @Operation(summary = "This end point is used to report a new incident")
    public ResponseEntity<IncidentResponse> createNewIncident(
            @Valid @RequestBody IncidentRequest incidentRequest){
        return new ResponseEntity<>(incidentsService.createNewIncident(incidentRequest), HttpStatus.CREATED);
    }

    /**
     * GET method for retrieving an incident by ID.
     * @param incidentId The ID of the incident to retrieve.
     * @return ResponseEntity with the incident information if found,
     * or an error response if the incident is not found.
     */

    @GetMapping("/incidents/{incidentId}")
    @Operation(summary = "Using this end point one can find an incident by an id")
    public ResponseEntity<IncidentsDTO> getAnIncidentById(
            
            @PathVariable("incidentId") String incidentId
    ){

        IncidentsDTO incidentsDTO = incidentsService.findAnIncidentById(incidentId);
        return new ResponseEntity<>(incidentsDTO, HttpStatus.OK);

    }

    /**
     * GET method for retrieving all the pending incidents.
     * @return ResponseEntity with a list of all pending incident if successful,
     * or an error response if an exception occurs during the retrieval process.
     */
    @GetMapping("/incidents")
    @Operation(summary = "Using this end point we can get all the pending incidents")
    public ResponseEntity<List<IncidentsDTO>> getAllPendingIncidents(){
        return new ResponseEntity<>(incidentsService.getAllPendingIncidents(), HttpStatus.OK);
    }

    /**
     * PUT method for updating an incident with investigation report.
     * @param incidentId The ID of the incident to update.
     * @param investigationReportDTO DTO containing the investigation report.
     * @return ResponseEntity indicating the status of update operation.
     */
    @PutMapping("/incidents/{incidentId}/investigation-report")
    @Operation(summary = "Using this end point a pending incident will be updated")
    public ResponseEntity<InvestigationReportDTO> updateAnIncident(
           @PathVariable("incidentId") String incidentId, @Valid @RequestBody InvestigationReportDTO investigationReportDTO
    ){
        InvestigationReportDTO investigationReport = incidentsService.updateAnIncident(incidentId, investigationReportDTO);
        return new ResponseEntity<>(investigationReport,HttpStatus.ACCEPTED);
    }


}
