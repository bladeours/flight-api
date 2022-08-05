package com.flight.api.controller;

import com.flight.api.model.Flight;
import com.flight.api.service.FlightService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{id}")
    public Flight getFlight(@PathVariable String id){
        return  flightService.getFlight(Long.parseLong(id));
    }
}
