package com.flight.api.controller;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;
import com.flight.api.service.CompanyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{id}")
    public Company getCompany(@PathVariable String id){
        return companyService.getCompany(Long.parseLong(id));
    }

    @GetMapping("/flights/{companyId}")
    public List<Flight> getFlightsForCompany(@PathVariable String companyId){
//        System.out.println(companyService.getFlightsForCompany(Long.parseLong(companyId)));
        return companyService.getFlightsForCompany(Long.parseLong(companyId));
//        return null;
    }
}
