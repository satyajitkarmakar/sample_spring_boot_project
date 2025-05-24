package com.example.dtos;

import com.example.entities.InvestigationResult;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvestigationReportDTO {
    @NotBlank(message = "Finding should not be null")
    private String findings;
    @NotBlank(message = "Suggestion should not be null")
    private String suggestions;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Investigation Date should not be null")
    private LocalDate investigationDate;
    private InvestigationResult investigationResult;
    private String incidentId;

}
