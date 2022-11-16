package com.flight.api.controller;

import com.flight.api.service.CompanyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CompanyControllerTest {
    @Mock
    CompanyService companyService;
    CompanyController companyController;

    @BeforeEach
    void setUp() {
        companyController = new CompanyController(companyService);
    }

    @Test
    public void getCompany_IdIsNotANumber_ThrowException(){
        assertThrows(NumberFormatException.class,() -> {companyController.getCompany("test");});
    }

    @Test
    public void getFlightsForCompany_IdIsNotANumber_ThrowException(){
        assertThrows(NumberFormatException.class,() -> {companyController.getFlightsForCompany("test");});
    }
}