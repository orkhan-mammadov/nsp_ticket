package com.orkhanmammadov.nsp_ticket.service;

import com.orkhanmammadov.nsp_ticket.dao.ProjectRepository;
import com.orkhanmammadov.nsp_ticket.dto.ProjectDTO;
import com.orkhanmammadov.nsp_ticket.entity.Project;
import com.orkhanmammadov.nsp_ticket.exception.ResourceNotFoundException;
import com.orkhanmammadov.nsp_ticket.mapper.ProjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ProjectMapper projectMapper;

    @Transactional
    public ProjectDTO getProject(int projectId) {
        return projectMapper.toDto(
                projectRepository.findById(projectId).orElseThrow(
                ()-> new ResourceNotFoundException("Project does not exist with id: " + projectId))
        );
    }

    @Transactional
    public List<ProjectDTO> getProjects() {
        return projectRepository.findAll()
                .stream()
                .map(project -> projectMapper.toDto(project))
                .collect(Collectors.toList());
    }

    @Transactional
    public ProjectDTO createProject(Project project) {
        return projectMapper.toDto(projectRepository.save(project));
    }

    @Transactional
    public ProjectDTO updateProject(Project project) {
        if(!projectRepository.existsById(project.getId()))
            throw new ResourceNotFoundException("Project does not exist with id: "+project.getId());
        return projectMapper.toDto(projectRepository.save(project));
    }

    @Transactional
    public Object deleteProject(int projectId) {
        if(!projectRepository.existsById(projectId))
            throw new ResourceNotFoundException("Project does not exist with id: "+projectId);
        else
        {
            projectRepository.deleteById(projectId);
            return new ResponseEntity<Object>("Project deleted with id: "+projectId, HttpStatus.OK);
        }
    }
}
