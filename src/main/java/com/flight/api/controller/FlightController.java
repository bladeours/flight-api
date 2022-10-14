package com.flight.api.controller;

import com.flight.api.exception.DateFormatException;
import com.flight.api.model.Flight;
import com.flight.api.model.dto.CompanyDTO;
import com.flight.api.model.dto.FlightDTO;
import com.flight.api.service.FlightService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flight")
public class FlightController {

    private final FlightService flightService;
    private final ModelMapper modelMapper = new ModelMapper();
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{id}")
    public FlightDTO getFlight(@PathVariable String id){
        try{
            return modelMapper.map(flightService.getFlight(Long.parseLong(id)),FlightDTO.class);
        }catch (NumberFormatException e){
            throw new NumberFormatException("flight id must be a number");
        }
    }

    @GetMapping("/company/{id}")
    public CompanyDTO getCompanyForFlight(@PathVariable String id){
        try {
            return flightService.getCompany(Long.parseLong(id));
        }catch (NumberFormatException e){
            throw new NumberFormatException("flight id must be a number");
        }
    }

    @GetMapping("{departureCode}/{arrivalCode}")
    public List<FlightDTO> getFlightForCodes(@PathVariable String departureCode, @PathVariable String arrivalCode,
                                             @RequestParam String date) throws DateFormatException {
        System.out.println(flightService.getFlightForCodes(departureCode, arrivalCode, date));
        return flightService.getFlightForCodes(departureCode, arrivalCode, date);
    }

    @PostMapping
    public FlightDTO addFlight(@RequestBody FlightDTO flightDTO){
        return flightService.addFlight(modelMapper.map(flightDTO, Flight.class));
    }

}
