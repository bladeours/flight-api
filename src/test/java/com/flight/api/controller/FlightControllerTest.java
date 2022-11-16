package com.flight.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flight.api.model.Flight;
import com.flight.api.model.dto.CompanyDTO;
import com.flight.api.model.dto.FlightDTO;
import com.flight.api.model.dto.raw.AirportRAW;
import com.flight.api.service.FlightService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.sql.Time;
import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class FlightControllerTest {

    @Autowired
    private FlightController flightController;
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    FlightService flightService;

    private static FlightDTO flightDTO;

    @BeforeAll
    public static void init(){
        AirportRAW airportRAW = new AirportRAW("XYZ","testCity","testCountry");
        CompanyDTO companyDTO = new CompanyDTO(1234L,"testCompany");
        Time flightTime = new Time(224142);
        Timestamp timestamp = new Timestamp(2421412);
        flightDTO = new FlightDTO(123L, airportRAW, airportRAW, timestamp, flightTime, 123, 120,
                21.15, companyDTO, 12345);
    }

    @Test
    public void getFlight_IdIsNotANumber_ThrowException(){
        assertThrows(NumberFormatException.class,() -> {flightController.getFlight("test");});
    }

    @Test
    public void getCompanyForFlight_IdIsNotANumber_ThrowException(){
        assertThrows(NumberFormatException.class,() -> {flightController.getCompanyForFlight("test");});
    }

    @Test
    public void addFlight_WrongBody_BadRequestResponse() throws Exception {
        JsonObject flightJson = new Gson().fromJson(objectMapper.writeValueAsString(flightDTO), JsonObject.class);
        flightJson.remove("distance_km");

        ResultActions response = mockMvc.perform(post("/flight")
                .contentType(MediaType.APPLICATION_JSON)
                .content(flightJson.toString())
        );

        response.andExpect(status().isBadRequest());
    }

    @Test
    public void addFlight_CorrectBody_CorrectResponse() throws Exception {
        when(flightService.addFlight(new Flight())).thenReturn(new FlightDTO());

        ResultActions response = mockMvc.perform(post("/flight")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(flightDTO))
        );
        response.andExpect(status().isCreated());
    }

    @Test
    public void getFlightForCodes_badDateFormat_BadRequestResponse() throws Exception {
        ResultActions response = mockMvc.perform(get("/flight/WAW/ABY?date=34234234234"));
        response.andExpect(status().isBadRequest());
    }
}
