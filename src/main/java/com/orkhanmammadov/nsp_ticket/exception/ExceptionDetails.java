package com.orkhanmammadov.nsp_ticket.exception;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@Builder
public class ExceptionDetails {
    private final String message;
    private final HttpStatus httpStatus;
    private final Date timestamp;
    private final String details;
}
