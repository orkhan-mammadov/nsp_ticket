package com.orkhanmammadov.nsp_ticket.mapper;

import com.orkhanmammadov.nsp_ticket.dto.CommentDTO;
import com.orkhanmammadov.nsp_ticket.entity.Comment;
import com.orkhanmammadov.nsp_ticket.nsp_global.mapper.GenericMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CommentMapper extends GenericMapper<Comment, CommentDTO> {
    @Mappings({
            @Mapping(source = "employee.id",target = "employeeId"),
            @Mapping(source = "ticket.id", target = "ticketId")
    })
    CommentDTO toDto(Comment comment);

    @InheritInverseConfiguration
    Comment toModel(CommentDTO commentDTO);
}
