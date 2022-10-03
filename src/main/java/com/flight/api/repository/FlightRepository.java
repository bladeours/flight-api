package com.flight.api.repository;

import com.flight.api.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long>, FlightCustomRepository {

    @Query("SELECT f from Flight f where f.departureAirport.code = ?1 and f.arrivalAirport.code = ?2")
    List<Flight> getFlightForCodes(String departureCode, String arrivalCode);
}
