package com.example.repositories;

import com.example.entities.InvestigationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvestigationDetailsRepository extends JpaRepository<InvestigationDetails, Integer> {
    @Query("SELECT iv FROM InvestigationDetails iv WHERE iv.incidents.incidentId = :incidentId")
    List<InvestigationDetails> findInvestigationsByIncidentId(@Param("incidentId") String incidentId);
}
