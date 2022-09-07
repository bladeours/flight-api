package com.flight.api.controller;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;
import com.flight.api.model.dto.CompanyDTO;
import com.flight.api.model.dto.FlightDTO;
import com.flight.api.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;
    private final ModelMapper modelMapper = new ModelMapper();

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/{id}")
    public CompanyDTO getCompany(@PathVariable String id){
        return modelMapper.map(companyService.getCompany(Long.parseLong(id)), CompanyDTO.class);
    }

    @GetMapping("/flights/{companyId}")
    public List<FlightDTO> getFlightsForCompany(@PathVariable String companyId){
        return modelMapper.map(companyService.getFlightsForCompany(Long.parseLong(companyId)),
                new TypeToken<List<FlightDTO>>() {}.getType());
    }
}
