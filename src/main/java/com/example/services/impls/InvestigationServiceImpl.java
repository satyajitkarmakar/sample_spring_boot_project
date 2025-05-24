package com.example.services.impls;

import com.example.dtos.InvestigationReportDTO;
import com.example.entities.InvestigationDetails;
import com.example.exceptions.ResourceNotFoundException;
import com.example.repositories.InvestigationDetailsRepository;
import com.example.services.InvestigationService;
import com.example.utilities.InvestigationReportMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InvestigationServiceImpl implements InvestigationService {

    private final InvestigationDetailsRepository investigationDetailsRepository;
    private final InvestigationReportMapper investigationReportMapper;

    @Override
    public List<InvestigationReportDTO> getAllInvestigationDetails(String incidentId) {
        List<InvestigationDetails> investigationDetails = investigationDetailsRepository.findInvestigationsByIncidentId(incidentId);
        if(investigationDetails.isEmpty()) {
            throw new ResourceNotFoundException("There is no investigation report for the given id: " + incidentId);
        }

        return investigationDetails.stream()
                .map(investigationReportMapper::toInvestigationReport)
                .toList();
    }
}
