package com.orkhanmammadov.nsp_ticket.controller;

import com.orkhanmammadov.nsp_ticket.nsp_global.dao.GenericRepository;
import com.orkhanmammadov.nsp_ticket.dto.EmployeeDTO;
import com.orkhanmammadov.nsp_ticket.entity.Employee;
import com.orkhanmammadov.nsp_ticket.nsp_global.mapper.GenericMapper;
import com.orkhanmammadov.nsp_ticket.nsp_global.controller.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController extends GenericController<Employee,EmployeeDTO> {
    public EmployeeController(GenericRepository<Employee> repository, GenericMapper<Employee, EmployeeDTO> mapper) {
        super(repository, mapper);
    }
}
