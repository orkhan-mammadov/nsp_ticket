package com.orkhanmammadov.nsp_ticket.controller;

import com.orkhanmammadov.nsp_ticket.nsp_global.dao.GenericRepository;
import com.orkhanmammadov.nsp_ticket.dto.CommentDTO;
import com.orkhanmammadov.nsp_ticket.entity.Comment;
import com.orkhanmammadov.nsp_ticket.nsp_global.mapper.GenericMapper;
import com.orkhanmammadov.nsp_ticket.nsp_global.controller.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
public class CommentController extends GenericController<Comment, CommentDTO> {
    protected CommentController(GenericRepository<Comment> repository, GenericMapper<Comment, CommentDTO> mapper) {
        super(repository, mapper);
    }
}
