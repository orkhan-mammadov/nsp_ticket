package com.orkhanmammadov.nsp_ticket.nsp_global.dto;

public interface GenericDTO<E> {
    // update current instance with provided data
    void update(E source);

    // based on current data create new instance with new id
    E createNewInstance();

    int getId();
}
