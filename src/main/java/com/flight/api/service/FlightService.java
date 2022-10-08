package com.flight.api.service;

import com.flight.api.exception.DateFormatException;
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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public List<FlightDTO> getFlightForCodes(String departureCode, String arrivalCode, String date) throws DateFormatException {
        if(!dateIsValid(date, "yyyy-MM-dd")){
            throw new DateFormatException("Incorrect date format: '2023-13-18'");
        }
        return modelMapper.map(flightRepository.getFlightForCodes(departureCode, arrivalCode, date),
                new TypeToken<List<FlightDTO>>() {}.getType());
    }

    private boolean dateIsValid(String date, String format) {
        DateFormat sdf = new SimpleDateFormat(format);
        sdf.setLenient(false);
        try {
            sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

}
