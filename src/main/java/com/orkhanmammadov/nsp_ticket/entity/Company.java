package com.orkhanmammadov.nsp_ticket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.orkhanmammadov.nsp_ticket.nsp_global.entity.GenericEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "company")
public class Company implements GenericEntity<Company> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @Column(name = "email")
    private String email;

    @Column(name = "logo")
    private String logo;

    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "company",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Project> project;

//    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
//    @JsonIgnore
//    private List<Employee> employees;

    @Override
    public void update(Company source) {
        this.id = source.getId();
        this.name = source.getName();
        this.shortName = source.getShortName();
        this.email = source.getEmail();
        this.logo = source.getLogo();
        this.note = source.getNote();
    }

    @Override
    public Company createNewInstance() {
        Company newInstance = new Company();
        newInstance.update(this);
        return newInstance;
    }
}
