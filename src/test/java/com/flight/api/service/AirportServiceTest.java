package com.flight.api.service;

import com.flight.api.repository.AirportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AirportServiceTest {
    @Mock
    AirportRepository airportRepository;
    AirportService airportService;

    @BeforeEach
    void setUp() {
        airportService = new AirportService(airportRepository);
    }

    @Test
    public void findByCode_NotFound_ThrowException(){
        assertThrows(NoSuchElementException.class,() -> {airportService.findByCode("test");});
    }


}