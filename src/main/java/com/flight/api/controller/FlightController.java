package com.flight.api.controller;

import com.flight.api.model.Company;
import com.flight.api.model.Flight;
import com.flight.api.model.dto.CompanyDTO;
import com.flight.api.model.dto.FlightDTO;
import com.flight.api.service.FlightService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;
    private ModelMapper modelMapper = new ModelMapper();
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{id}")
    public FlightDTO getFlight(@PathVariable String id){
        return modelMapper.map(flightService.getFlight(Long.parseLong(id)),FlightDTO.class);
    }

    @GetMapping("/company/{id}")
    public CompanyDTO getCompanyForFlight(@PathVariable String id){
        return flightService.getCompany(Long.parseLong(id));
    }
}
