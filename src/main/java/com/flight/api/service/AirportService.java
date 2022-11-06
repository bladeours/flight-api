package com.flight.api.service;

import com.flight.api.model.Airport;
import com.flight.api.model.dto.AirportDTO;
import com.flight.api.model.dto.FlightDTO;
import com.flight.api.model.dto.raw.AirportRAW;
import com.flight.api.repository.AirportRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public interface AirportService {

    public List<AirportRAW> listAllAirports();

    public AirportDTO findByCode(String code);
}
