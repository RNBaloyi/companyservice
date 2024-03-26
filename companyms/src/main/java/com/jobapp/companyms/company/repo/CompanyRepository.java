package com.jobapp.companyms.company.repo;


import com.jobapp.companyms.company.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company,Long> {
    Optional<Company> getCompanyById(Long companyId);
}
