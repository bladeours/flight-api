package com.flight.api.repository;

import com.flight.api.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long>, CompanyCustomRepository {

}
