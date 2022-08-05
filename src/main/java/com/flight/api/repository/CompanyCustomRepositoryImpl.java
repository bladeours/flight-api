package com.flight.api.repository;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
