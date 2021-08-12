package com.orkhanmammadov.nsp_ticket.dto;


import com.orkhanmammadov.nsp_ticket.nsp_global.dto.GenericDTO;
import lombok.Data;

@Data
public class EmployeeDTO implements GenericDTO<EmployeeDTO> {

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

    @Override
    public void update(EmployeeDTO source) {
        this.name = source.getName();
        this.lastName = source.getLastName();
        this.fatherName = source.getFatherName();
        this.email = source.getEmail();
        this.phone = source.getPhone();
        this.note = source.getNote();
        this.companyId = source.getCompanyId();
        this.projectId = source.getProjectId();
        this.userId = source.getUserId();
    }

    @Override
    public EmployeeDTO createNewInstance() {
        EmployeeDTO newInstance = new EmployeeDTO();
        newInstance.update(this);
        return newInstance;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
