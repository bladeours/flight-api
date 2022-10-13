package com.flight.api.model.dto;

import com.flight.api.model.dto.raw.AirportRAW;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class FlightDTO {

    private Long id;
    private AirportRAW departureAirport;
    private AirportRAW arrivalAirport;
    private Timestamp departureDate;
    private Time flightTime;
    private int allSeats;
    private int freeSeats;
    private double price;
    private CompanyDTO company;
    private int distance_km;

    public FlightDTO() {
    }

    public FlightDTO(Long id, AirportRAW departureAirport, AirportRAW arrivalAirport, Timestamp departureDate, Time flightTime, int allSeats,
                     int freeSeats, double price, CompanyDTO company, int distance_km) {
        this.id = id;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
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

    public Timestamp getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Timestamp departureDate) {
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

    public AirportRAW getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(AirportRAW departureAirport) {
        this.departureAirport = departureAirport;
    }

    public AirportRAW getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(AirportRAW arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    @Override
    public String toString() {
        return "FlightDTO{" +
                "id=" + id +
                ", departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                ", departureDate=" + departureDate +
                ", flightTime=" + flightTime +
                ", allSeats=" + allSeats +
                ", freeSeats=" + freeSeats +
                ", price=" + price +
                ", company=" + company +
                ", distance_km=" + distance_km +
                '}';
    }
}
