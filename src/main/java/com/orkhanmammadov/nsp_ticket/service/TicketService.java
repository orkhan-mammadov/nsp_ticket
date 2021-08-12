package com.orkhanmammadov.nsp_ticket.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.orkhanmammadov.nsp_ticket.dao.TicketRepository;
import com.orkhanmammadov.nsp_ticket.dto.TicketDTO;
import com.orkhanmammadov.nsp_ticket.entity.DbFile;
import com.orkhanmammadov.nsp_ticket.entity.Ticket;
import com.orkhanmammadov.nsp_ticket.exception.ResourceNotFoundException;
import com.orkhanmammadov.nsp_ticket.mapper.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketMapper ticketMapper;

    @Value("${file.upload-dir}")
    String FILE_DIRECTORY;

    @Transactional
    public Ticket createTicket(String ticketAsString, MultipartFile[] multipartFiles) {
        TicketDTO ticketDTO = stringToTicket(ticketAsString);
        Ticket ticket = ticketMapper.toModel(ticketDTO);

        if(multipartFiles != null)
            for(DbFile files : fileToEntity(multipartFiles)) {
                ticket.addFile(files);
            }

        return ticketRepository.save(ticket);
    }
//    @Transactional
//    public Ticket createTicket(TicketDTO ticketDTO, MultipartFile[] multipartFiles) {
//        Ticket ticket = ticketMapper.toModel(ticketDTO);
//
//        if(multipartFiles != null)
//            for(DbFile files : fileToEntity(multipartFiles)) {
//                ticket.addFile(files);
//            }
//
//        return ticketRepository.save(ticket);
//    }

    @Transactional
    public Ticket updateTicket(int ticketId, String ticketAsString, MultipartFile[] multipartFiles) {
        if(ticketId<1 && !ticketRepository.existsById(ticketId))
            throw new ResourceNotFoundException("Ticket does not exist with id: "+ticketId);

        TicketDTO ticketDTO = stringToTicket(ticketAsString);
        Ticket ticket = ticketMapper.toModel(ticketDTO);
        ticket.setFiles(ticketRepository.findById(ticketId).orElse(new Ticket()).getFiles());
        ticket.setId(ticketId);

        if(multipartFiles != null)
            for(DbFile files : fileToEntity(multipartFiles))
                ticket.addFile(files);

        return ticketRepository.save(ticket);
    }

    private TicketDTO stringToTicket(String ticketAsString) {
        TicketDTO ticketDTO = new TicketDTO();
        try {

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            objectMapper.registerModule(new JavaTimeModule());

            ticketDTO = objectMapper.readValue(ticketAsString,TicketDTO.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return ticketDTO;
    }

    private List<DbFile> fileToEntity(MultipartFile[] multipartFiles){
        List<DbFile> files = new ArrayList<>();
        for(MultipartFile multipartFile : multipartFiles) {
            if(!multipartFile.isEmpty()){
                try{
                    DbFile dbFile = new DbFile();
                    File file = new File(FILE_DIRECTORY + multipartFile.getOriginalFilename());
                    file.createNewFile();
                    FileOutputStream fos = new FileOutputStream(file);
                    fos.write(multipartFile.getBytes());
                    fos.close();
                    dbFile.setName(multipartFile.getOriginalFilename());
                    dbFile.setType(1);
                    files.add(dbFile);
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return files;
    }
}
