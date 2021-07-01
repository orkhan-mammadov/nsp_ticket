package com.orkhanmammadov.nsp_ticket.dto;

import lombok.Data;
import sun.security.util.Password;

@Data
public class EmployeeFormDTO {
    private Integer id;
    private String name;
    private String lastName;
    private String fatherName;
    private String email;
    private String phone;
    private String note;
    private Integer companyId;
    private Integer projectId;
    private String userName;
    private Password password;
    private Password matchingPassword;
}
