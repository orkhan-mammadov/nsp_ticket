package com.orkhanmammadov.nsp_ticket.nsp_global.dao;

import com.orkhanmammadov.nsp_ticket.nsp_global.entity.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T extends GenericEntity<T>> extends JpaRepository<T, Integer> {
}