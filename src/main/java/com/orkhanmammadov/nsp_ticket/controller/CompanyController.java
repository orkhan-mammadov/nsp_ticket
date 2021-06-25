package com.orkhanmammadov.nsp_ticket.controller;

import com.orkhanmammadov.nsp_ticket.entity.Company;
import com.orkhanmammadov.nsp_ticket.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {
    
    @Autowired
    private CompanyService companyService;
    
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company){
        return new ResponseEntity<Company>(companyService.createCompany(company), HttpStatus.CREATED);
    }

    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompany(@PathVariable int companyId){
        return new ResponseEntity<Company>(companyService.getCompany(companyId),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Company>> getCompanies(){
        return new ResponseEntity<List<Company>>(companyService.getCompanies(),HttpStatus.OK);
    }

    @DeleteMapping("/{companyId}")
    public ResponseEntity<Object> deleteCompany(@PathVariable int companyId){
        return companyService.deleteCompany(companyId);
    }

    @PutMapping()
    public ResponseEntity<Company> updateCompany(@RequestBody Company company){
        return companyService.updateCompany(company);
    }

}
