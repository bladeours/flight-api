package com.flight.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

@Entity
@Table(name = "flight")
public class Flight {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "departure_airport")
    private Airport departureAirport;
    @ManyToOne
    @JoinColumn(name = "arrival_airport")
    private Airport arrivalAirport;
    @Column
    private Timestamp departureDate;
    @Column
    private Time flightTime;
    @Column
    private int allSeats;
    @Column
    private int freeSeats;
    @Column
    private double price;
    @ManyToOne
    @JoinColumn(name = "company_id")
    @JsonBackReference
    private Company company;
    @Column
    private int distance_km;

    public Flight() {
    }

    public Flight(Long id, Airport departureAirport, Airport arrivalAirport, Timestamp departureDate, Time flightTime,
                  int allSeats, int freeSeats, double price, Company company, int distance_km) {
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
        System.out.println("ustawiam id: " + id);
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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public int getDistance_km() {
        return distance_km;
    }

    public void setDistance_km(int distance_km) {
        this.distance_km = distance_km;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", departureDate=" + departureDate +
                ", flightTime=" + flightTime +
                ", allSeats=" + allSeats +
                ", freeSeats=" + freeSeats +
                ", price=" + price +
                ", company=" + company.getId() +
                ", distance_km=" + distance_km +
                '}';
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }
}

