package com.orkhanmammadov.nsp_ticket.dto;


import lombok.Data;

@Data
public class EmployeeDTO {

    private Integer id;
    private String name;
    private String lastName;
    private String fatherName;
    private String email;
    private String phone;
    private String note;
    private Integer companyId;
    private Integer projectId;
    private Integer userId;

}
