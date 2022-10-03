package com.flight.api.service;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;
import com.flight.api.model.dto.CompanyDTO;
import com.flight.api.model.dto.FlightDTO;
import com.flight.api.model.dto.raw.AirportRAW;
import com.flight.api.repository.FlightRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class FlightService {

    private final FlightRepository flightRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight getFlight(Long id){
        try {
            return flightRepository.findById(id).get();
        }catch (NoSuchElementException e){
            throw  new NoSuchElementException("There is no flight with id=" + id );
        }
    }

    public CompanyDTO getCompany(Long id){
        Flight flight = getFlight(id);
        return modelMapper.map(flightRepository.getCompany(flight), CompanyDTO.class);
    }

    public List<FlightDTO> getFlightForCodes(String departureCode, String arrivalCode){
        return modelMapper.map(flightRepository.getFlightForCodes(departureCode, arrivalCode),
                new TypeToken<List<FlightDTO>>() {}.getType());
    }

}
