package com.orkhanmammadov.nsp_ticket.dto;

import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ResponseDTO {
    private Integer code;
    private String message;
    private Object data;
}
