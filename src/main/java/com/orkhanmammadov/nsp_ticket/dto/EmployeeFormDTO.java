package com.orkhanmammadov.nsp_ticket.dto;

import com.orkhanmammadov.nsp_ticket.validation.FieldMatch;
import lombok.Data;
import sun.security.util.Password;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@FieldMatch.List({
        @FieldMatch(userName = "userName", first = "password", second = "matchingPassword", message = "The password fields must match!")
})
public class EmployeeFormDTO {
    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String lastName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String fatherName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String email;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")
    private String phone;

    private String note;

    @NotNull(message = "is required")
    private Integer companyId;

    @NotNull(message = "is required")
    private Integer projectId;

    private String userName;

    @Size(min = 8, message = "Should not be less than 8 character!")
    private String password;

    @Size(min = 8, message = "Should not be less than 8 character!")
    private String matchingPassword;
}
