package com.orkhanmammadov.nsp_ticket.mapper;

import com.orkhanmammadov.nsp_ticket.dto.TicketDTO;
import com.orkhanmammadov.nsp_ticket.entity.Ticket;
import com.orkhanmammadov.nsp_ticket.nsp_global.mapper.GenericMapper;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TicketMapper extends GenericMapper<Ticket, TicketDTO> {

    @Override
    @Mappings({
            @Mapping(source = "company.id",target = "companyId"),
            @Mapping(source = "project.id",target = "projectId")
    })
    TicketDTO toDto(Ticket model);

    @Override
    @InheritInverseConfiguration
    Ticket toModel(TicketDTO dto);
}
