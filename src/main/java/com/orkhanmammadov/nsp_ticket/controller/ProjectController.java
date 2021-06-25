package com.orkhanmammadov.nsp_ticket.controller;

import com.orkhanmammadov.nsp_ticket.dto.ProjectDTO;
import com.orkhanmammadov.nsp_ticket.entity.Project;
import com.orkhanmammadov.nsp_ticket.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDTO> getProject(@PathVariable int projectId){
        return new ResponseEntity<ProjectDTO>(
                projectService.getProject(projectId),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getProjects(){
        return new ResponseEntity<List<ProjectDTO>>(projectService.getProjects(),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProjectDTO> createProject(@RequestBody Project project){

        return new ResponseEntity<ProjectDTO>(projectService.createProject(project),HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProjectDTO> updateProject(@RequestBody Project project){
        return new ResponseEntity<ProjectDTO>(projectService.updateProject(project),HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Object> deleteProject(@PathVariable int projectId){
        return new ResponseEntity<Object>(projectService.deleteProject(projectId),HttpStatus.OK);
    }
}
