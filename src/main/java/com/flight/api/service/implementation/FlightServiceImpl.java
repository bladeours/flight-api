package com.flight.api.service.implementation;

import com.flight.api.model.Flight;
import com.flight.api.model.dto.CompanyDTO;
import com.flight.api.model.dto.FlightDTO;
import com.flight.api.repository.FlightRepository;
import com.flight.api.service.FlightService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class FlightServiceImpl implements FlightService {
    private final FlightRepository flightRepository;
    private ModelMapper modelMapper = new ModelMapper();

    public FlightServiceImpl(FlightRepository flightRepository) {
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

    public List<FlightDTO> getFlightForCodes(String departureCode, String arrivalCode, String date) {


        return modelMapper.map(flightRepository.getFlightForCodes(departureCode, arrivalCode, date),
                new TypeToken<List<FlightDTO>>() {}.getType());
    }

    public FlightDTO addFlight(Flight flight){
        return modelMapper.map(flightRepository.save(flight), FlightDTO.class);
    }

    private boolean dateIsValid(String date) {
        return date.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$");
    }

    public List<FlightDTO> getAllFlights(){
        return modelMapper.map(flightRepository.findAll(),new TypeToken<List<FlightDTO>>() {}.getType());
    }
}

