package com.orkhanmammadov.nsp_ticket.mapper;

import com.orkhanmammadov.nsp_ticket.dto.ProjectDTO;
import com.orkhanmammadov.nsp_ticket.entity.Project;
import com.orkhanmammadov.nsp_ticket.nsp_global.mapper.GenericMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends GenericMapper<Project,ProjectDTO> {

    @Mapping(source = "company.id", target = "companyId")
    ProjectDTO toDto(Project project);

    @Mapping(source = "companyId", target = "company.id")
    Project toModel(ProjectDTO projectDTO);

}
