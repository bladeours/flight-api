package com.flight.api.repository;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;

public interface FlightCustomRepository {
    Company getCompany(Flight flight);

//    Flight getFlightForCodes(String departureCode, String arrivalCode);
}
