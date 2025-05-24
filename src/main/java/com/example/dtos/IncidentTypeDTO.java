package com.example.dtos;

import lombok.Builder;

/**
 * 
 * This class uses Java's {@code record} feature, which provides a concise way
 * to create immutable data carriers.
 * Records automatically generate constructors, accessors, {@code equals()},
 * {@code hashCode()}, and {@code toString()} methods,
 * reducing boilerplate code and ensuring immutability.
 * The {@link Builder} annotation from Lombok is used to provide a builder
 * pattern for this record,
 * making it easier and more readable to create instances, especially when
 * dealing with multiple fields.
 * 
 * @param incidentTypeId    Unique identifier for the incident type.
 * @param type              The type/category of the incident.
 * @param expectedSLAInDays Expected Service Level Agreement in days for this
 *                          incident type.
 */
@Builder
public record IncidentTypeDTO(
                int incidentTypeId,
                String type,
                int expectedSLAInDays) {

}
