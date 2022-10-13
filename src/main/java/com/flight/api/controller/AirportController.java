package com.flight.api.controller;

import com.flight.api.model.dto.AirportDTO;
import com.flight.api.model.dto.raw.AirportRAW;
import com.flight.api.service.AirportService;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airport")
public class AirportController {
    private final AirportService airportService;
    private ModelMapper modelMapper = new ModelMapper();

    public AirportController(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping("/{code}")
    public AirportDTO getAirport(@PathVariable String code){
        return airportService.findByCode(code);
    }

    @GetMapping("/raw/{code}")
    public AirportRAW getAirportRaw(@PathVariable String code){
        return modelMapper.map(airportService.findByCode(code), AirportRAW.class);
    }

    @GetMapping("/airports")
    public List<AirportRAW> getAirports(){
        return airportService.listAllAirports();
    }
}
