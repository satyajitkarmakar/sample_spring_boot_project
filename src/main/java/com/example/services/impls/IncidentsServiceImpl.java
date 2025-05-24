package com.example.services.impls;

import com.example.dtos.*;
import com.example.entities.*;
import com.example.exceptions.CannotReportIncidentException;
import com.example.exceptions.BookingIdFoundException;
import com.example.exceptions.IdNotFoundException;
import com.example.exceptions.ResourceNotFoundException;
import com.example.repositories.IncidentTypeRepository;
import com.example.repositories.IncidentsRepository;
import com.example.repositories.InvestigationDetailsRepository;
import com.example.services.IncidentsService;
import com.example.utilities.IncidentMapper;
import com.example.utilities.InvestigationReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IncidentsServiceImpl implements IncidentsService {
    private final IncidentsRepository incidentsRepository;
    private final IncidentTypeRepository incidentTypeRepository;
    private final IncidentMapper incidentMapper;
    private final InvestigationDetailsRepository investigationDetailsRepository;
    private final InvestigationReportMapper investigationReportMapper;

    public IncidentResponse createNewIncident(IncidentRequest incidentRequest) {

        //using an id we are finding a specific incident type object
        IncidentTypes incidentType = incidentTypeRepository.findById(incidentRequest.getIncidentTypeId())
                .orElseThrow(() -> new IdNotFoundException("There is no valid incident type present with the given id!!!"));

        validateIncidentDate(incidentRequest.getIncidentDate());

        //This method will validate the report date if it is within two days
        //of incident date or not
        validateReportDate(incidentRequest.getReportDate());

        //this method will validate if a booking id for an incident report is present or not
        validateBookingId(incidentRequest.getBookingId());

        Incidents mappedIncidents = incidentMapper.toIncidents(incidentRequest);
        mappedIncidents.setIncidentId(createCustomIncidentId(incidentRequest.getIncidentDate()));
        mappedIncidents.setResolutionETA(incidentRequest.getReportDate().plusDays(incidentType.getExpectedSLAInDays()));
        mappedIncidents.setStatus(IncidentStatusValue.PENDING);

        //we are storing an incident report in the database
        Incidents saveIncidents = incidentsRepository.save(mappedIncidents);
        return new IncidentResponse(saveIncidents.getIncidentId());
    }

    @Override
    public IncidentsDTO findAnIncidentById(String incidentId) {
        Incidents incidents = incidentsRepository.findById(incidentId)
                .orElseThrow(() -> new IdNotFoundException("There is incident present with the given incident id " + incidentId));

        return incidentMapper.toIncidentDTO(incidents);
    }

    @Override
    public List<IncidentsDTO> getAllPendingIncidents() {
        List<Incidents> incidents = incidentsRepository.findByStatus(IncidentStatusValue.PENDING);

        if(incidents.isEmpty()) {
            throw new ResourceNotFoundException("No incidents found!!");
        }

        return incidents.stream()
                .map(incidentMapper::toIncidentDTO)
                .toList();
    }

    @Override
    public InvestigationReportDTO updateAnIncident(String incidentId, InvestigationReportDTO investigationReportDTO) {
        if(investigationReportDTO == null) {
            throw new NullPointerException("Investigation report should not be null!!!");
        }

        Incidents existingIncident = incidentsRepository.findById(incidentId)
                .orElseThrow(() -> new IdNotFoundException("There is no incident present with the given ID: " + incidentId));


        if(investigationReportDTO.getInvestigationResult().equals(InvestigationResult.RESOLVED)) {
            existingIncident.setStatus(IncidentStatusValue.CLOSED);
            existingIncident.setInvestigatedByUserId((int)createInvestigatorId());

        } else {
            existingIncident.setInvestigatedByUserId((int)createInvestigatorId());

        }

        Incidents savedIncident = incidentsRepository.save(existingIncident);
        InvestigationDetails investigationDetails = investigationReportMapper.toInvestigationDetails(investigationReportDTO);
        investigationDetails.setIncidents(savedIncident);
        InvestigationDetails savedDetails= investigationDetailsRepository.save(investigationDetails);
        return investigationReportMapper.toInvestigationReport(savedDetails);
    }

    private String createCustomIncidentId(LocalDate incidentDate) {
        return incidentDate.getYear() + "-" + getRandomUniqueId(9000, 1000);
    }

    private long createInvestigatorId() {
        return getRandomUniqueId(9000, 1);
    }

    private void validateReportDate(LocalDate reportDate) {
        if (reportDate.isAfter(LocalDate.now()) || reportDate.isBefore(LocalDate.now())) {
            throw new CannotReportIncidentException("Report Date should be current date");
        }
    }

    private void validateIncidentDate(LocalDate incidentDate){
        LocalDate currDate = LocalDate.now();
        LocalDate prevDate = LocalDate.now().minusDays(2);
        if(incidentDate.isAfter(currDate) || incidentDate.isBefore(prevDate)){
            throw new CannotReportIncidentException("incident date must be current date or a maximum of 2 days before.");
        }
    }

    private void validateBookingId(int bookingId) {
        if (incidentsRepository.existsByBookingId(bookingId)) {
            throw new BookingIdFoundException("Booking ID is already present");
        }
    }

    private long getRandomUniqueId(int high, int low) {
        UUID uuid = UUID.randomUUID();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        return (Math.abs(leastSignificantBits) % high) + low;
    }
}
