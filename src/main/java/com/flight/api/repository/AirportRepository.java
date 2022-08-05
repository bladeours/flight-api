package com.flight.api.repository;

import com.flight.api.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport,String> {
}
