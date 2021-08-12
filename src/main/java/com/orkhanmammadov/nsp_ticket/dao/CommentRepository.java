package com.orkhanmammadov.nsp_ticket.dao;

import com.orkhanmammadov.nsp_ticket.entity.Comment;
import com.orkhanmammadov.nsp_ticket.nsp_global.dao.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends GenericRepository<Comment> {
}
