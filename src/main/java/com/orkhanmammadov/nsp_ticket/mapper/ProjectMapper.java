package com.orkhanmammadov.nsp_ticket.mapper;

import com.orkhanmammadov.nsp_ticket.dto.ProjectDTO;
import com.orkhanmammadov.nsp_ticket.entity.Project;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    @Mapping(source = "company.id", target = "companyId")
    ProjectDTO toDto(Project project);

}
