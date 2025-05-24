package com.example.utilities;

import com.example.dtos.IncidentTypeDTO;
import com.example.entities.IncidentTypes;
import org.springframework.stereotype.Service;

@Service
public class IncidentTypeMapper {

    public IncidentTypeDTO toIncidentTypeDTO(IncidentTypes incidentTypes){
        if(incidentTypes == null){
            throw new NullPointerException("Incident Type Should Not Be Null");
        }

        return new IncidentTypeDTO(
                incidentTypes.getIncidentTypeId(),
                incidentTypes.getType(),
                incidentTypes.getExpectedSLAInDays());
    }
}
