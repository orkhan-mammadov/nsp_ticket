package com.orkhanmammadov.nsp_ticket.controller;

import com.orkhanmammadov.nsp_ticket.nsp_global.dao.GenericRepository;
import com.orkhanmammadov.nsp_ticket.dto.ProjectDTO;
import com.orkhanmammadov.nsp_ticket.entity.Project;
import com.orkhanmammadov.nsp_ticket.nsp_global.mapper.GenericMapper;
import com.orkhanmammadov.nsp_ticket.nsp_global.controller.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
public class ProjectController extends GenericController<Project,ProjectDTO> {
    public ProjectController(GenericRepository<Project> repository, GenericMapper<Project, ProjectDTO> mapper) {
        super(repository, mapper);
    }
}
