package com.flight.api.service.implementation;

import com.flight.api.repository.CompanyRepository;
import com.flight.api.service.CompanyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceImplTest {
    @Mock
    CompanyRepository companyRepository;
    CompanyService companyService;

    @BeforeEach
    void setUp() {
        companyService = new CompanyServiceImpl(companyRepository);
    }

    @Test
    public void findById_NotFound_ThrowException(){
        assertThrows(NoSuchElementException.class,() -> {companyService.getCompany(1L);});
    }
}