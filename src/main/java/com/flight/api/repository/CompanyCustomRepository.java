package com.flight.api.repository;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;

import java.util.List;

public interface CompanyCustomRepository {

    List<Flight> findFlightsForCompany(Company company);

}
