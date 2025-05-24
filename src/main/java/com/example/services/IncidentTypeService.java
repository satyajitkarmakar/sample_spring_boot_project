package com.example.services;

import com.example.dtos.IncidentTypeDTO;

import java.util.List;

public interface IncidentTypeService {

    // this method will return a list of incident type present in  the database
    List<IncidentTypeDTO> getAllIncidentTypes();
}
