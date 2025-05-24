package com.example.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Investigation_Details")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvestigationDetails {

    @Id
    @Column(name = "Investigation_Details_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int investigationDetailsId;

    @Column(name = "Findings")
    private String findings;

    @Column(name = "Suggestions")
    private String suggestions;

    @Column(name = "Investigation_Date")
    private LocalDate investigationDate;

    @Column(name = "Investigation_Result")
    @Enumerated(EnumType.STRING)
    private InvestigationResult investigationResult;

    @ManyToOne
    @JoinColumn(
            name = "Incident_Id"
    )
    private Incidents incidents;
}
