package com.flight.api.service.implementation;

import com.flight.api.repository.AirportRepository;
import com.flight.api.service.AirportService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class AirportServiceImplTest {
    @Mock
    AirportRepository airportRepository;
    AirportService airportService;

    @BeforeEach
    void setUp() {
        airportService = new AirportServiceImpl(airportRepository);
    }

    @Test
    public void findByCode_NotFound_ThrowException(){
        assertThrows(NoSuchElementException.class,() -> {airportService.findByCode("test");});
    }


}