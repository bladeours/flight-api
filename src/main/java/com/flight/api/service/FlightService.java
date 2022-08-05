package com.flight.api.service;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;
import com.flight.api.model.dto.CompanyDTO;
import com.flight.api.repository.FlightRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class FlightService {

    private final FlightRepository flightRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight getFlight(Long id){
        return flightRepository.findById(id).get();
    }

    public CompanyDTO getCompany(Long id){
        Flight flight = getFlight(id);
        return modelMapper.map(flightRepository.getCompany(flight), CompanyDTO.class);
    }

}
