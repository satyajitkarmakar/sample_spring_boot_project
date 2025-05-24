package com.example.utilities;

import com.example.dtos.IncidentsDTO;
import com.example.dtos.IncidentRequest;
import com.example.entities.IncidentTypes;
import com.example.entities.Incidents;
import org.springframework.stereotype.Service;

@Service
public class IncidentMapper {

    public Incidents toIncidents(IncidentsDTO incidentsDTO){
        if(incidentsDTO == null) {
            throw new NullPointerException("Incident DTO cannot be null");
        }
        IncidentTypes incidentTypes = new IncidentTypes();
        incidentTypes.setIncidentTypeId(incidentsDTO.incidentTypeId());

        return Incidents.builder()
                .incidentId(incidentsDTO.incidentId())
                .incidentDate(incidentsDTO.incidentDate())
                .reportDate(incidentsDTO.reportDate())
                .resolutionETA(incidentsDTO.resolutionETA())
                .investigatedByUserId(incidentsDTO.investigatedByUserId())
                .incidentDetails(incidentsDTO.incidentDetails())
                .bookingId(incidentsDTO.bookingId())
                .status(incidentsDTO.status())
                .incidentTypes(incidentTypes)
                .build();
    }

    public IncidentsDTO toIncidentDTO(Incidents incidents){
        if(incidents == null) {
            throw new NullPointerException("Incident cannot be null");
        }

        return IncidentsDTO.builder()
                .incidentId(incidents.getIncidentId())
                .incidentDate(incidents.getIncidentDate())
                .reportDate(incidents.getReportDate())
                .resolutionETA(incidents.getResolutionETA())
                .investigatedByUserId(incidents.getInvestigatedByUserId())
                .incidentDetails(incidents.getIncidentDetails())
                .bookingId(incidents.getBookingId())
                .status(incidents.getStatus())
                .incidentTypeId(incidents.getIncidentTypes().getIncidentTypeId())
                .build();
    }

    public Incidents toIncidents(IncidentRequest incidentRequest){
        if(incidentRequest == null){
            throw new NullPointerException("IncidentDTO can not be null.");
        }

        IncidentTypes incidentTypes = new IncidentTypes();
        incidentTypes.setIncidentTypeId(incidentRequest.getIncidentTypeId());

        return Incidents.builder()
                .incidentDate(incidentRequest.getIncidentDate())
                .reportDate(incidentRequest.getReportDate())
                .incidentDetails(incidentRequest.getIncidentDetails())
                .bookingId(incidentRequest.getBookingId())
                .incidentTypes(incidentTypes)
                .build();
    }

}
