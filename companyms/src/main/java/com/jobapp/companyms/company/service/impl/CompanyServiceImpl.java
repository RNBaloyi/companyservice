package com.jobapp.companyms.company.service.impl;


import com.jobapp.companyms.company.dto.ReviewMessage;
import com.jobapp.companyms.company.model.Company;
import com.jobapp.companyms.company.repo.CompanyRepository;
import com.jobapp.companyms.company.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
   private CompanyRepository companyRepository;


    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateCompany(Long id, Company newCompany) {
       Optional<Company> optionalCompany =companyRepository.findById(id);
       if (optionalCompany.isPresent()){
           Company existingCompany = optionalCompany.get();
           existingCompany.setName(newCompany.getName());
           existingCompany.setDescription(newCompany.getDescription());
           //existingCompany.setJobs(newCompany.getJobs());
           companyRepository.save(existingCompany);
           return true;
       }
        return false;
    }

    @Override
    public boolean deleteCompanyById(Long id) {

        if (companyRepository.existsById(id)){
            companyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public void updateCompanyRating(ReviewMessage reviewMessage) {
        System.out.println(reviewMessage.getDescription());
    }
}
