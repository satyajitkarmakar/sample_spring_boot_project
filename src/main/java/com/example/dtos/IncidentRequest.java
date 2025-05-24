package com.example.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncidentRequest {

    @PastOrPresent(message = "Incident Date Should Be In Past Or Present")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate incidentDate;

    @PastOrPresent
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate reportDate;

    @NotNull(message = "Incident details cannot be null")
    @Size(min = 10, max = 255, message = "Incident details must be between 10 to 255 characters")
    private String incidentDetails;

    @NotNull(message = "Booking id is required")
    private int bookingId;

    @NotNull(message = "Incident type id is required")
    private int incidentTypeId;

}
