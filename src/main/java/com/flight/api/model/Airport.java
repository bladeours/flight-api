package com.flight.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "airport")
public class Airport {

    @Id
    private String code;
    @Column
    private String city;
    @Column
    private String country;
    @OneToMany(mappedBy = "departureAirport")
    private List<Flight> departureFlights;
    @OneToMany(mappedBy = "arrivalAirport")
    private List<Flight> arrivalFlights;

    public Airport() {
    }

    public Airport(String code, String city, String country, List<Flight> departureFlights, List<Flight> arrivalFlights) {
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

    public List<Flight> getDepartureFlights() {
        return departureFlights;
    }

    public void setDepartureFlights(List<Flight> departureFlights) {
        this.departureFlights = departureFlights;
    }

    public List<Flight> getArrivalFlights() {
        return arrivalFlights;
    }

    public void setArrivalFlights(List<Flight> arrivalFlights) {
        this.arrivalFlights = arrivalFlights;
    }
}
