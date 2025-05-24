package com.example.repositories;

import com.example.entities.IncidentStatusValue;
import com.example.entities.Incidents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IncidentsRepository extends JpaRepository<Incidents, String> {
    /**
     * Checks whether an incident exists for the given booking ID.
     *
     * @param bookingId the ID of the booking to check for existence
     * @return {@code true} if an incident exists for the specified booking ID, {@code false} otherwise
     */
    boolean existsByBookingId(int bookingId);

    /**
     * Retrieves a list of incidents that match the specified status.
     *
     * @param status the status to filter incidents by
     * @return a list of {@link Incidents} with the specified status
     */
    List<Incidents> findByStatus(IncidentStatusValue status);
}
