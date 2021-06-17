package com.orkhanmammadov.nsp_ticket.service;

import com.orkhanmammadov.nsp_ticket.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    public User findByUsername(String username);
}
