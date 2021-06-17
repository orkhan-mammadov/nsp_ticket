package com.orkhanmammadov.nsp_ticket.mapper;

import com.orkhanmammadov.nsp_ticket.dao.CompanyRepository;
import com.orkhanmammadov.nsp_ticket.dao.EmployeeRepository;
import com.orkhanmammadov.nsp_ticket.dto.EmployeeDTO;
import com.orkhanmammadov.nsp_ticket.entity.Employee;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {EmployeeRepository.class, CompanyRepository.class})
public interface EmployeeMapper{

//    @Mapping(source = "companyId",target = "company")
//    Employee toEntity(EmployeeDTO employeeDTO);

    @Mappings(
            {@Mapping(source = "company.id", target = "companyId"),
            @Mapping(source = "project.id", target = "projectId"),
            @Mapping(source = "user.id", target = "userId")}
    )
    EmployeeDTO toDto(Employee employee);

}
