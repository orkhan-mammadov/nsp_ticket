package com.orkhanmammadov.nsp_ticket.dao;

import com.orkhanmammadov.nsp_ticket.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket,Integer> {
}
