package com.orkhanmammadov.nsp_ticket.service;

import com.orkhanmammadov.nsp_ticket.dao.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FileService {

    @Autowired
    private FileRepository fileRepository;
}
