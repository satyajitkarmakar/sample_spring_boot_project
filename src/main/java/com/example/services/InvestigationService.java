package com.example.services;

import com.example.dtos.InvestigationReportDTO;

import java.util.List;

public interface InvestigationService {
    List<InvestigationReportDTO> getAllInvestigationDetails(String incidentId);
}
