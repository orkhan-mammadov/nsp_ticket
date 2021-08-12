package com.orkhanmammadov.nsp_ticket.exception;

import com.orkhanmammadov.nsp_ticket.dto.ResponseDTO;
import org.hibernate.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ResponseDTO> notFoundExceptionHandling(ResourceNotFoundException exception, WebRequest request){
        ExceptionDetails exceptionDetails =
                ExceptionDetails.builder()
                        .message(exception.getMessage())
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .timestamp(new Date())
                        .details(request.getDescription(false))
                        .build();
        List<Object> objects = new ArrayList<>();
        objects.add(exceptionDetails);
        ResponseDTO responseDTO = ResponseDTO.builder()
                .code(404)
                .message(exception.getMessage())
                .data(objects).build();
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> globalExceptionHandling(Exception exception, WebRequest request){
//        ExceptionDetails exceptionDetails =
//                ExceptionDetails.builder()
//                        .message(exception.getMessage())
//                        .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//                        .timestamp(new Date())
//                        .details(request.getDescription(false))
//                        .build();
//
//        return new ResponseEntity<>(exceptionDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//    }


    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<Object> validation(TypeMismatchException typeMismatchException){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                "Invalid value '${typeMismatchException.value}'",
                typeMismatchException);
    }
}
