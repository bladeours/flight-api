package com.flight.api.service;

import com.flight.api.model.Flight;
import com.flight.api.repository.FlightRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight getFlight(Long id){
        return flightRepository.findById(id).get();
    }
}
