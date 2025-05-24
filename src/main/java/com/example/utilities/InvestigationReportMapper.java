package com.example.utilities;

import com.example.dtos.InvestigationReportDTO;
import com.example.entities.Incidents;
import com.example.entities.InvestigationDetails;
import org.springframework.stereotype.Service;

@Service
public class InvestigationReportMapper {

    public InvestigationDetails toInvestigationDetails(InvestigationReportDTO investigationReportDTO){
        InvestigationDetails investigationDetails = new InvestigationDetails();

        investigationDetails.setFindings(investigationReportDTO.getFindings());
        investigationDetails.setSuggestions(investigationReportDTO.getSuggestions());
        investigationDetails.setInvestigationDate(investigationReportDTO.getInvestigationDate());
        investigationDetails.setInvestigationResult(investigationReportDTO.getInvestigationResult());

        Incidents incidents = new Incidents();
        incidents.setIncidentId(investigationReportDTO.getIncidentId());
        investigationDetails.setIncidents(incidents);

        return investigationDetails;
    }

    public InvestigationReportDTO toInvestigationReport(InvestigationDetails investigationDetails){
        return new InvestigationReportDTO(
                investigationDetails.getFindings(),
                investigationDetails.getSuggestions(),
                investigationDetails.getInvestigationDate(),
                investigationDetails.getInvestigationResult(),
                investigationDetails.getIncidents().getIncidentId()
        );
    }
}
