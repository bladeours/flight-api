package com.flight.api.repository;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select  f from Flight f where f.company = :company")
    List<Flight> findFlightsForCompany(Company company);

    Company findByFlights(Flight flight);
}
