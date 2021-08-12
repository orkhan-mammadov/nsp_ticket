package com.orkhanmammadov.nsp_ticket.dto;

import com.orkhanmammadov.nsp_ticket.nsp_global.dto.GenericDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProjectDTO implements GenericDTO<ProjectDTO> {
    private Integer id;
    private String name;
    private String shortName;
    private Integer companyId;

    @Override
    public void update(ProjectDTO source) {
        this.name = source.getName();
        this.shortName = source.getShortName();
        this.companyId = source.getCompanyId();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public ProjectDTO createNewInstance() {
        ProjectDTO newInstance = new ProjectDTO();
        newInstance.update(this);
        return newInstance;
    }
}
