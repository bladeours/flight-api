package com.flight.api.service;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;
import com.flight.api.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Transactional
public interface CompanyService {

    List<Company> listAllCompanies();
    Company getCompany(Long id);
    List<Flight> getFlightsForCompany(Long companyId);
    Company getCompanyForFlight(Flight flight);

}
