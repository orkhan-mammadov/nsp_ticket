package com.orkhanmammadov.nsp_ticket.service;

import com.orkhanmammadov.nsp_ticket.dao.EmployeeRepository;
import com.orkhanmammadov.nsp_ticket.dto.EmployeeDTO;
import com.orkhanmammadov.nsp_ticket.entity.Employee;
import com.orkhanmammadov.nsp_ticket.exception.ResourceNotFoundException;
import com.orkhanmammadov.nsp_ticket.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeMapper employeeMapper;

    @Transactional
    public List<EmployeeDTO> getEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(employee -> employeeMapper.toDto(employee))
                .collect(Collectors.toList());
    }

    @Transactional
    public EmployeeDTO getEmployee(int employeeId){
        return employeeMapper.toDto(employeeRepository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundException("Employee is not found with id: "+employeeId)));
    }

    @Transactional
    public Object deleteEmployee(int employeeId) {
        if(!employeeRepository.existsById(employeeId))
            throw new ResourceNotFoundException("Employee does not exist with id: "+employeeId);
        employeeRepository.deleteById(employeeId);
        return new ResponseEntity<>("Employee is successfully deleted with id: "+employeeId, HttpStatus.OK);
    }

    @Transactional
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDTO) {
       if(!employeeRepository.existsById(employeeDTO.getId()))
                throw  new ResourceNotFoundException("Employee does not exist with id: "+employeeDTO.getId());
        return employeeMapper.toDto(employeeRepository.save(employeeMapper.toModel(employeeDTO)));
    }
}
