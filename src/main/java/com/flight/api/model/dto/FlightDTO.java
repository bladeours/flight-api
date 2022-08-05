package com.flight.api.model.dto;

import com.flight.api.model.Company;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.sql.Time;

public class FlightDTO {

    private Long id;
//    private Airport departureAirport;
//    private Airport arrivalAirport;
    private Date departureDate;
    private Time flightTime;
    private int allSeats;
    private int freeSeats;
    private double price;
    private CompanyDTO company;
    private int distance_km;

    public FlightDTO() {
    }

    public FlightDTO(Long id, Date departureDate, Time flightTime, int allSeats,
                     int freeSeats, double price, CompanyDTO company, int distance_km) {
        this.id = id;
        this.departureDate = departureDate;
        this.flightTime = flightTime;
        this.allSeats = allSeats;
        this.freeSeats = freeSeats;
        this.price = price;
        this.company = company;
        this.distance_km = distance_km;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Time getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Time flightTime) {
        this.flightTime = flightTime;
    }

    public int getAllSeats() {
        return allSeats;
    }

    public void setAllSeats(int allSeats) {
        this.allSeats = allSeats;
    }

    public int getFreeSeats() {
        return freeSeats;
    }

    public void setFreeSeats(int freeSeats) {
        this.freeSeats = freeSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CompanyDTO getCompany() {
        return company;
    }

    public void setCompany(CompanyDTO company) {
        this.company = company;
    }

    public int getDistance_km() {
        return distance_km;
    }

    public void setDistance_km(int distance_km) {
        this.distance_km = distance_km;
    }
}
