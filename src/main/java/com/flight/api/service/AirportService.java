package com.flight.api.service;

import com.flight.api.model.Airport;
import com.flight.api.repository.AirportRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirportService {
    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> listAllAirports(){
        return airportRepository.findAll();
    }

    public Airport findByCode(String code){
        return airportRepository.findById(code).get();
    }
}
