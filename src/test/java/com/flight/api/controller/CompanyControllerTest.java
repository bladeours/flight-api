package com.flight.api.controller;

import com.flight.api.service.CompanyService;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyControllerTest {
    @Autowired
    CompanyController companyController;

    @Test
    public void getCompany_IdIsNotANumber_ThrowException(){
        assertThrows(NumberFormatException.class,() -> {companyController.getCompany("test");});
    }

    @Test
    public void getFlightsForCompany_IdIsNotANumber_ThrowException(){
        assertThrows(NumberFormatException.class,() -> {companyController.getFlightsForCompany("test");});
    }
}