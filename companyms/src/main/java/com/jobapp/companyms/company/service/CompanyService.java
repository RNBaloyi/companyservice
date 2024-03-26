package com.jobapp.companyms.company.service;



import com.jobapp.companyms.company.dto.ReviewMessage;
import com.jobapp.companyms.company.model.Company;

import java.util.List;

public interface CompanyService {
    void createCompany(Company company);
    List<Company> getAllCompanies();
    Company getCompanyById(Long id);
    boolean updateCompany(Long Id,Company company);
    boolean deleteCompanyById(Long id);
    public void updateCompanyRating(ReviewMessage reviewMessage);


    /*
    GET /companies
    PUT /companies/{id}
    POST /companies
    DELETE /companies/{id}
    GET /companies/{id}
    */
}
