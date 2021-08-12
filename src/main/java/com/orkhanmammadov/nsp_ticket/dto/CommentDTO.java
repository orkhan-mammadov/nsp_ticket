package com.orkhanmammadov.nsp_ticket.dto;

import com.orkhanmammadov.nsp_ticket.nsp_global.dto.GenericDTO;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDTO implements GenericDTO<CommentDTO> {
    private Integer id;
    private LocalDateTime dateTime;
    private String comment;
    private String createdBy;
    private Integer employeeId;
    private Integer ticketId;

    @Override
    public void update(CommentDTO source) {
        this.dateTime = source.getDateTime();
        this.comment = source.getComment();
        this.createdBy = source.getCreatedBy();
        this.employeeId = source.getEmployeeId();
        this.ticketId = source.getTicketId();
    }

    @Override
    public CommentDTO createNewInstance() {
        CommentDTO newInstance = new CommentDTO();
        newInstance.update(this);
        return newInstance;
    }

    @Override
    public int getId(){
        return this.id;
    }
}
