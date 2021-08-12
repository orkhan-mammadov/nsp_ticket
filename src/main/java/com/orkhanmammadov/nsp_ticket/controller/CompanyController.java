package com.orkhanmammadov.nsp_ticket.controller;

import com.orkhanmammadov.nsp_ticket.nsp_global.dao.GenericRepository;
import com.orkhanmammadov.nsp_ticket.dto.CompanyDTO;
import com.orkhanmammadov.nsp_ticket.entity.Company;
import com.orkhanmammadov.nsp_ticket.nsp_global.mapper.GenericMapper;
import com.orkhanmammadov.nsp_ticket.nsp_global.controller.GenericController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/company")
public class CompanyController extends GenericController<Company, CompanyDTO> {
    public CompanyController(GenericRepository<Company> repository, GenericMapper<Company,CompanyDTO> mapper) {
        super(repository,mapper);
    }
}
