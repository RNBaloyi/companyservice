package com.jobapp.companyms.company.controller;


import com.jobapp.companyms.company.model.Company;
import com.jobapp.companyms.company.service.CompanyService;
import com.jobapp.companyms.company.service.impl.CompanyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("company added successfully ", HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<List<Company>> getAll(){
        List<Company> companies = companyService.getAllCompanies();
        return new ResponseEntity<>(companies,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ResponseEntity<Optional<Company>>  getCompanyById(@PathVariable Long id){

        Optional<Company> company= Optional.ofNullable(companyService.getCompanyById(id));
        if (company.isPresent()){

            return new ResponseEntity<>(company,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PutMapping("{id}")
    ResponseEntity<String> updateCompany(@PathVariable Long id,@RequestBody Company company){
        boolean isUpdated = companyService.updateCompany(id,company);

        if (isUpdated){
            return new ResponseEntity<>("company updated successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("company not found",HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean isDeleted = companyService.deleteCompanyById(id);

        if (isDeleted){
            return new ResponseEntity<>("company deleted successfully",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("company not found",HttpStatus.NOT_FOUND);
        }
    }




    /*
       void createCompany(Company company);
    List<Company> getAll();
    Company getCompanyById(Long id);
    boolean updateCompany(Long Id,Company company);
    boolean deleteCompany(Long id);*/




}
