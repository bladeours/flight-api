package com.flight.api.repository;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
public class FlightCustomRepositoryImpl implements FlightCustomRepository{
    @Override
    public Company getCompany(Flight flight) {
        return flight.getCompany();
    }

//    @Override
//    public Flight getFlightForCodes(String departureCode, String arrivalCode) {
//
//    }
}
