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

    public List<Company> listAllCompanies();

    public Company getCompany(Long id);

    public List<Flight> getFlightsForCompany(Long companyId);

}
