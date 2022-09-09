package com.flight.api.repository;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;
import com.flight.api.model.dto.FlightDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Transactional
public class CompanyCustomRepositoryImpl implements CompanyCustomRepository{


    public CompanyCustomRepositoryImpl() {
    }

    @Override
    public List<Flight> findFlightsForCompany(Company company) {
        List<Flight> flights = company.getFlights();
        return flights;
    }
}
