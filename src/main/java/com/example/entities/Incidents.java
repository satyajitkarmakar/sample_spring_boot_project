package com.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Incidents")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Incidents {

    @Id
    @Column(name = "Incident_Id")
    private String incidentId;

    @Column(name = "Incident_Date")
    private LocalDate incidentDate;

    @Column(name = "Report_Date")
    private LocalDate reportDate;

    @Column(name = "Resolution_ETA")
    private LocalDate resolutionETA;

    @Column(name = "Investigated_By_User_Id")
    private int investigatedByUserId;

    @Column(name = "Incident_Details")
    private String incidentDetails;

    @Column(name = "Booking_Id")
    private int bookingId;

    @Column(name = "Status")
    @Enumerated(EnumType.STRING)
    private IncidentStatusValue status;

    @ManyToOne
    @JoinColumn(
          name = "Incident_Type_Id"
    )
    private IncidentTypes incidentTypes;

}
