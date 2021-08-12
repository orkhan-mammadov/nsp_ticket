package com.orkhanmammadov.nsp_ticket.nsp_global.mapper;

public interface GenericMapper <T extends Object, E extends Object>{
    T toModel(E dto);
    E toDto(T model);
}
