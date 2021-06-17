package com.orkhanmammadov.nsp_ticket.service;

import com.orkhanmammadov.nsp_ticket.dao.EmployeeRepository;
import com.orkhanmammadov.nsp_ticket.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployee(int employeeId){
        return employeeRepository.findById(employeeId).get();
    }

    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
