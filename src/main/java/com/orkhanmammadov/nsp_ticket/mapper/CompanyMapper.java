package com.orkhanmammadov.nsp_ticket.mapper;

import com.orkhanmammadov.nsp_ticket.dto.CompanyDTO;
import com.orkhanmammadov.nsp_ticket.entity.Company;
import com.orkhanmammadov.nsp_ticket.nsp_global.mapper.GenericMapper;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface CompanyMapper extends GenericMapper<Company, CompanyDTO> {
    CompanyDTO toDto(Company company);
    Company toModel(CompanyDTO companyDTO);
}
