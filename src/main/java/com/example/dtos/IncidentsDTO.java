package com.example.dtos;


import com.example.entities.IncidentStatusValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import java.time.LocalDate;

@Builder
public record IncidentsDTO(
         String incidentId,

         @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate incidentDate,

         @JsonFormat(pattern = "yyyy-MM-dd")
         LocalDate reportDate,

        @JsonFormat(pattern = "yyyy-MM-dd")
        LocalDate resolutionETA,

        int investigatedByUserId,

        String incidentDetails,
         int bookingId,

       IncidentStatusValue status,

       int incidentTypeId
) {

}
