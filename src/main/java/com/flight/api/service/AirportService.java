package com.flight.api.service;

import com.flight.api.model.Airport;
import com.flight.api.model.dto.AirportDTO;
import com.flight.api.repository.AirportRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AirportService {
    private final AirportRepository airportRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<Airport> listAllAirports(){
        return airportRepository.findAll();
    }

    public AirportDTO findByCode(String code){
        return modelMapper.map(airportRepository.findById(code).get(), AirportDTO.class);
    }
}
