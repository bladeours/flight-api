package com.flight.api.service.implementation;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;
import com.flight.api.repository.CompanyRepository;
import com.flight.api.service.CompanyService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> listAllCompanies(){
        return companyRepository.findAll();
    }

    public Company getCompany(Long id){
        try{
            return companyRepository.findById(id).get();
        }catch (NoSuchElementException e){
            throw new NoSuchElementException("there is no company with id=" + id);
        }

    }

    public List<Flight> getFlightsForCompany(Long companyId){
        Company company = getCompany(companyId);
        return companyRepository.findFlightsForCompany(company);
    }
}
