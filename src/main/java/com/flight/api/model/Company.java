package com.flight.api.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "company")
public class Company {
    @Id
    private Long id;
    @Column
    private String name;
    @JsonManagedReference
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "company")
    private List<Flight> flights;

    public Company() {
    }

    public Company(Long id, String name, List<Flight> flights) {
        this.id = id;
        this.name = name;
        this.flights = flights;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }


}
