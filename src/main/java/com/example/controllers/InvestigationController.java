package com.example.controllers;

import com.example.dtos.InvestigationReportDTO;
import com.example.services.InvestigationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/api/investigation-details")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200/")
public class InvestigationController {
    private final InvestigationService investigationService;

    @GetMapping("/{incidentId}")
    private ResponseEntity<List<InvestigationReportDTO>> findInvestigationReportByIncidentId(@PathVariable("incidentId") String incidentId) {
        return new ResponseEntity<>(investigationService.getAllInvestigationDetails(incidentId), HttpStatus.OK);
    }
}
