package com.orkhanmammadov.nsp_ticket.service;

import com.orkhanmammadov.nsp_ticket.dao.CompanyRepository;
import com.orkhanmammadov.nsp_ticket.entity.Company;
import com.orkhanmammadov.nsp_ticket.exception.ResourceNotFoundException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CompanyService {
    
    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    @Transactional
    public Company getCompany(int companyId) {
        return companyRepository.findById(companyId).orElseThrow(()->
//                new NotFoundException(String.format("Company does not exist with id: %d",companyId)));
                new RuntimeException(String.format("Company does not exist with id: %d",companyId)));
    }

    @Transactional
    public List<Company> getCompanies() {
        return companyRepository.findAll();
    }

    @Transactional
    @SneakyThrows
    public ResponseEntity<Object> deleteCompany(int companyId) {
        if(companyRepository.existsById(companyId)) {
            companyRepository.deleteById(companyId);
            return new ResponseEntity<>("Company seccuessfully deleted with id: "+ companyId,HttpStatus.OK);
        }
        else
            throw new ResourceNotFoundException("Company does not exist with id: "+companyId);
    }

    @Transactional
    public ResponseEntity<Company> updateCompany(Company company) {
        companyRepository.findById(company.getId()).orElseThrow(()->
                new ResourceNotFoundException("Company does not exist with id: "+company.getId()));
        companyRepository.save(company);
        return new ResponseEntity<>(company,HttpStatus.OK);
    }
}
