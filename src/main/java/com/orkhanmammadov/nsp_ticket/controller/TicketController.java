package com.orkhanmammadov.nsp_ticket.controller;

import com.orkhanmammadov.nsp_ticket.nsp_global.dao.GenericRepository;
import com.orkhanmammadov.nsp_ticket.dto.TicketDTO;
import com.orkhanmammadov.nsp_ticket.entity.Ticket;
import com.orkhanmammadov.nsp_ticket.nsp_global.mapper.GenericMapper;
import com.orkhanmammadov.nsp_ticket.nsp_global.controller.GenericController;
import com.orkhanmammadov.nsp_ticket.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/ticket")
public class TicketController extends GenericController<Ticket, TicketDTO> {

    public TicketController(GenericRepository<Ticket> repository, GenericMapper<Ticket, TicketDTO> mapper) {
        super(repository, mapper);
    }

    @Autowired
    private TicketService ticketService;


    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Ticket> create(@RequestPart("Ticket") String ticket, @RequestPart(value = "File",required = false) MultipartFile[] multipartFiles) {
        return new ResponseEntity<>(ticketService.createTicket(ticket,multipartFiles),HttpStatus.CREATED);
    }

//    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
//    public ResponseEntity<Ticket> create(@RequestBody TicketDTO ticketDTO, @RequestPart(value = "File",required = false) MultipartFile[] multipartFiles) {
//        return new ResponseEntity<>(ticketService.createTicket(ticketDTO,multipartFiles),HttpStatus.CREATED);
//    }

    @PutMapping(value = "/{ticketId}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Ticket> update(@PathVariable int ticketId,
                                               @RequestPart(value = "File",required = false) MultipartFile[] multipartFiles,
                                               @RequestPart("Ticket") String ticketAsString) {
        return new ResponseEntity<Ticket>(ticketService.updateTicket(ticketId, ticketAsString, multipartFiles),HttpStatus.OK);
    }
}
