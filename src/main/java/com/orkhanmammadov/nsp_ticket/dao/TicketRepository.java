package com.orkhanmammadov.nsp_ticket.dao;

import com.orkhanmammadov.nsp_ticket.entity.Ticket;
import com.orkhanmammadov.nsp_ticket.nsp_global.dao.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends GenericRepository<Ticket> {
}
