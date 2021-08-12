package com.orkhanmammadov.nsp_ticket.dto;

import com.orkhanmammadov.nsp_ticket.entity.DbFile;
import com.orkhanmammadov.nsp_ticket.nsp_global.dto.GenericDTO;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class TicketDTO implements GenericDTO<TicketDTO> {

    private int id;
    private LocalDateTime dateTime;
    private String title;
    private String content;
    private int priority;
    private String status;
    private LocalDateTime dueDate;
    private int companyId;
    private int projectId;
    private List<DbFile> files;

    @Override
    public void update(TicketDTO source) {
        this.dateTime = source.getDateTime();
        this.title = source.getTitle();
        this.content = source.getContent();
        this.priority = source.getPriority();
        this.status = source.getStatus();
        this.dueDate = source.getDueDate();
        this.companyId = source.getCompanyId();
        this.projectId = source.getProjectId();
        this.files = source.getFiles();
    }

    @Override
    public TicketDTO createNewInstance() {
        TicketDTO newInstance = new TicketDTO();
        newInstance.update(this);
        return newInstance;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
