package com.example.repositories;

import com.example.entities.IncidentTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncidentTypeRepository extends JpaRepository<IncidentTypes, Integer> {
}
