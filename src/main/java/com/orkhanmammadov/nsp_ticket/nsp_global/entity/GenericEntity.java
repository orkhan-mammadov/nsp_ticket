package com.orkhanmammadov.nsp_ticket.nsp_global.entity;

public interface GenericEntity <T>{

    // update current instance with provided data
    void update(T source);

    int getId();

    // based on current data create new instance with new id
    T createNewInstance();

}
