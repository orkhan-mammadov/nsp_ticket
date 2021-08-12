package com.orkhanmammadov.nsp_ticket.dto;

import com.orkhanmammadov.nsp_ticket.nsp_global.dto.GenericDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyDTO implements GenericDTO<CompanyDTO> {
    private int id;
    private String name;
    private String shortName;
    private String email;
    private String logo;
    private String note;

    @Override
    public void update(CompanyDTO source) {
        this.name = source.name;
        this.shortName = source.shortName;
        this.email = source.email;
        this.logo = source.logo;
        this.note = source.note;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public CompanyDTO createNewInstance() {
        CompanyDTO newInstance = new CompanyDTO();
        newInstance.update(this);
        return newInstance;
    }
}
