package com.orkhanmammadov.nsp_ticket.nsp_global.controller;

import com.orkhanmammadov.nsp_ticket.dto.ResponseDTO;
import com.orkhanmammadov.nsp_ticket.nsp_global.dao.GenericRepository;
import com.orkhanmammadov.nsp_ticket.nsp_global.dto.GenericDTO;
import com.orkhanmammadov.nsp_ticket.nsp_global.entity.GenericEntity;
import com.orkhanmammadov.nsp_ticket.nsp_global.mapper.GenericMapper;
import com.orkhanmammadov.nsp_ticket.nsp_global.service.GenericService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

public abstract class GenericController<T extends GenericEntity<T>,E extends GenericDTO<E>> {

    private final GenericService<T,E> service;

    protected GenericController(GenericRepository<T> repository, GenericMapper<T,E> mapper) {
        this.service = new GenericService<T,E>(repository,mapper) {};
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDTO> getOne(@PathVariable int id){
        Object obj = service.getSingle(id);
        List<Object> objects = new ArrayList<Object>();
        objects.add(obj);
        ResponseDTO responseDTO = ResponseDTO.builder()
                .code(200)
                .message("success")
                .data(objects)
                .build();
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<E>> getAll(
            @PageableDefault(sort = "id",direction = Sort.Direction.ASC,size = 5) Pageable page){
        return ResponseEntity.ok(service.getAll(page)); }

    @PostMapping
    public ResponseEntity<T> create(@RequestBody E newObj){
        return new ResponseEntity<T>(service.create(newObj), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody E newObj){
        return new ResponseEntity(service.update(newObj),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id){
        service.delete(id);
        return ResponseEntity.ok("Deleted");
    }
}
