package com.flight.api.repository;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CompanyCustomRepositoryImpl implements CompanyCustomRepository{

    private final SessionFactory sessionFactory;

    public CompanyCustomRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Flight> findFlightsForCompany(Company company) {
        System.out.println("XAFDAFGAWGAWGAWEG!!!!!!!!!!!!!!");
        List<Flight> flights = company.getFlights();
        return flights;
    }
}
