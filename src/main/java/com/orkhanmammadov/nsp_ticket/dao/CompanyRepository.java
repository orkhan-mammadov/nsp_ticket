package com.orkhanmammadov.nsp_ticket.dao;

import com.orkhanmammadov.nsp_ticket.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Integer> {

}
