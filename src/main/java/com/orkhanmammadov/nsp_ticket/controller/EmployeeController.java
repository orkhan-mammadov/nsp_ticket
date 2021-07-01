package com.orkhanmammadov.nsp_ticket.controller;

import com.orkhanmammadov.nsp_ticket.dto.EmployeeDTO;
import com.orkhanmammadov.nsp_ticket.mapper.EmployeeMapper;
import com.orkhanmammadov.nsp_ticket.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable int employeeId){
        return new ResponseEntity<>(employeeService.getEmployee(employeeId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(),HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Object> deleteEmployee(@PathVariable int employeeId){
        return new ResponseEntity<>(employeeService.deleteEmployee(employeeId), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.updateEmployee(employeeDTO),HttpStatus.OK);
    }

}
