package com.flight.api.service;

import com.flight.api.model.Flight;
import com.flight.api.model.dto.CompanyDTO;
import com.flight.api.model.dto.FlightDTO;

import java.util.List;


public interface FlightService {

    public Flight getFlight(Long id);

    public CompanyDTO getCompany(Long id);

    public List<FlightDTO> getFlightForCodes(String departureCode, String arrivalCode, String date);

    public FlightDTO addFlight(Flight flight);

    public List<FlightDTO> getAllFlights();

}
