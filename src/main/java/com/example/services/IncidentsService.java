package com.example.services;

import com.example.dtos.IncidentResponse;
import com.example.dtos.IncidentsDTO;
import com.example.dtos.InvestigationReportDTO;
import com.example.dtos.IncidentRequest;

import java.util.List;

public interface IncidentsService {
    /**
     * Creates a new incident based on the provided incident details.
     *
     * @param incidentRequest the data transfer object containing the details of the new incident
     * @return the response containing details of the created incident
     */
    IncidentResponse createNewIncident(IncidentRequest incidentRequest);

    /**
     * Retrieves an incident by its unique identifier.
     *
     * @param incidentId the unique ID of the incident to retrieve
     * @return the data transfer object representing the incident
     */
    IncidentsDTO findAnIncidentById(String incidentId);

    /**
     * Retrieves all incidents that are currently in a pending status.
     *
     * @return a list of data transfer objects representing the pending incidents
     */
    List<IncidentsDTO> getAllPendingIncidents();

    /**
     * Updates an existing incident with new investigation report details.
     *
     * @param incidentId the unique ID of the incident to update
     * @param investigationReportDTO the data transfer object containing the updated investigation report
     * @return the updated investigation report data transfer object
     */
    InvestigationReportDTO updateAnIncident(String incidentId, InvestigationReportDTO investigationReportDTO);

}
