package com.orkhanmammadov.nsp_ticket.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Company {

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

}
