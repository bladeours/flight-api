package com.flight.api.service;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;
import com.flight.api.repository.CompanyRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> listAllCompanies(){
        return companyRepository.findAll();
    }

    public Company getCompany(Long id){
        return companyRepository.findById(id).get();
    }

    public List<Flight> getFlightsForCompany(Long companyId){
        Company company = getCompany(companyId);
        return companyRepository.findFlightsForCompany(company);
    }

}
