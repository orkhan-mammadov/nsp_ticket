package com.orkhanmammadov.nsp_ticket.nsp_global.service;

import com.orkhanmammadov.nsp_ticket.dto.ResponseDTO;
import com.orkhanmammadov.nsp_ticket.nsp_global.dao.GenericRepository;
import com.orkhanmammadov.nsp_ticket.nsp_global.dto.GenericDTO;
import com.orkhanmammadov.nsp_ticket.nsp_global.entity.GenericEntity;
import com.orkhanmammadov.nsp_ticket.exception.ResourceNotFoundException;
import com.orkhanmammadov.nsp_ticket.nsp_global.mapper.GenericMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

public abstract class GenericService<T extends GenericEntity<T>,E extends GenericDTO<E>>{
    private final GenericRepository<T> repository;
    private final GenericMapper<T,E> mapper;

    protected GenericService(GenericRepository<T> genericRepository, GenericMapper<T, E> mapper) {
        this.repository = genericRepository;
        this.mapper = mapper;
    }

    @Transactional
    public T getSingle(int id){
        return repository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Element not found with id: "+id));
    }

    @Transactional
    public Page<E> getAll(Pageable page){
        List<E> list = repository.findAll(page).stream()
                .map(t -> mapper.toDto(t))
                .collect(Collectors.toList());
        Page<E> paged = new PageImpl<>(list);
        return paged;
    }

    @Transactional
    public T create(E newObject){
        T entity = mapper.toModel(newObject);
        return repository.saveAndFlush(entity);
    }

    @Transactional
    public T update(E newObject){
        T dbObject = getSingle(newObject.getId());
        dbObject = mapper.toModel(newObject);
        return repository.save(dbObject);
    }

    @Transactional
    public void delete(int id){
        if(!repository.existsById(id))
            throw new ResourceNotFoundException("Not found");
        repository.deleteById(id);
    }

}
