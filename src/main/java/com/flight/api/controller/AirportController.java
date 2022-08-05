package com.flight.api.controller;

import com.flight.api.model.Airport;
import com.flight.api.service.AirportService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/airport")
public class AirportController {
    private final AirportService airportService;

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/{code}")
    public Airport getAirport(@PathVariable String code){
        return airportService.findByCode(code);
    }
}
