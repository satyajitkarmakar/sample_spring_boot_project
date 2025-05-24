package com.example.services.impls;

import com.example.dtos.IncidentTypeDTO;
import com.example.repositories.IncidentTypeRepository;
import com.example.services.IncidentTypeService;
import com.example.utilities.IncidentTypeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IncidentTypeServiceImpl implements IncidentTypeService {
    private final IncidentTypeRepository incidentTypeRepository;
    private final IncidentTypeMapper incidentTypeMapper;

    /**
     *
     * @return List of incident types
     */
    @Override
    public List<IncidentTypeDTO> getAllIncidentTypes() {
        //using find all method we are finding all incident types that are present in the system
        //we are converting incident type entity to incident type dto
        //using map method, then we are converting it into list
        return incidentTypeRepository.findAll().stream()
                .map(incidentTypeMapper::toIncidentTypeDTO)
                .toList();
    }
}
