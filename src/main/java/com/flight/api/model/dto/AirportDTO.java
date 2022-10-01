package com.flight.api.model.dto;

import java.util.List;

public class AirportDTO {
    private String code;
    private String city;
    private String country;
    private List<FlightDTO> departureFlights;
    private List<FlightDTO> arrivalFlights;

    public AirportDTO() {
    }

    public AirportDTO(String code, String city, String country, List<FlightDTO> departureFlights, List<FlightDTO> arrivalFlights) {
        this.code = code;
        this.city = city;
        this.country = country;
        this.departureFlights = departureFlights;
        this.arrivalFlights = arrivalFlights;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<FlightDTO> getDepartureFlights() {
        return departureFlights;
    }

    public void setDepartureFlights(List<FlightDTO> departureFlights) {
        this.departureFlights = departureFlights;
    }

    public List<FlightDTO> getArrivalFlights() {
        return arrivalFlights;
    }

    public void setArrivalFlights(List<FlightDTO> arrivalFlights) {
        this.arrivalFlights = arrivalFlights;
    }

    @Override
    public String toString() {
        return "AirportDTO{" +
                "code='" + code + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", departureFlights=" + departureFlights +
                ", arrivalFlights=" + arrivalFlights +
                '}';
    }
}

