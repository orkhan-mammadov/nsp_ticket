package com.orkhanmammadov.nsp_ticket.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "employee")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String lastName;

    @Column(name = "fathername")
    private String fatherName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "note")
    private String note;

    @ManyToOne
    @JoinColumn(name = "fk_company")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "fk_project")
    private Project project;

    @OneToOne
    @JoinColumn(name = "fk_user")
    private User user;

    public Employee(String name, String lastName, String fatherName, String email, String phone, String note) {
        this.name = name;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.email = email;
        this.phone = phone;
        this.note = note;
    }

}
