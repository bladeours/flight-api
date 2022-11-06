package com.flight.api.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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