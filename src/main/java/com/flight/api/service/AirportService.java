package com.flight.api.service;

import com.flight.api.model.Airport;
import com.flight.api.model.dto.AirportDTO;
import com.flight.api.model.dto.FlightDTO;
import com.flight.api.model.dto.raw.AirportRAW;
import com.flight.api.repository.AirportRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class AirportService {
    private final AirportRepository airportRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<AirportRAW> listAllAirports(){
        return modelMapper.map(airportRepository.findAll(), new TypeToken<List<AirportRAW>>() {}.getType()) ;
    }

    public AirportDTO findByCode(String code){
        try{
            Airport airportTmp = airportRepository.findById(code).get();
            List<FlightDTO> departureFlightsDTO = modelMapper.map(airportTmp.getDepartureFlights(),
                    new TypeToken<List<FlightDTO>>() {}.getType());
            List<FlightDTO> arrivalFlightsDTO = modelMapper.map(airportTmp.getArrivalFlights(),
                    new TypeToken<List<FlightDTO>>() {}.getType());
            return new AirportDTO(airportTmp.getCode(), airportTmp.getCity(), airportTmp.getCountry(),
                    departureFlightsDTO, arrivalFlightsDTO);
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("There is no airport with code=" + code);
        }

    }
}
