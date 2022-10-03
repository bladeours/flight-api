package com.flight.api.repository;

import com.flight.api.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long>, FlightCustomRepository {

    @Query(value = "SELECT * from flight f where f.departure_airport = ?1 and f.arrival_airport = ?2" +
            " and DATE(f.departure_date) = ?3",
            nativeQuery = true)
    List<Flight> getFlightForCodes(String departureCode, String arrivalCode, String date);
}
