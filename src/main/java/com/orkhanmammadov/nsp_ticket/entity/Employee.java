package com.orkhanmammadov.nsp_ticket.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.orkhanmammadov.nsp_ticket.nsp_global.entity.GenericEntity;
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
public class Employee implements GenericEntity<Employee> {

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_user")
    private User user;

    public Employee(String name, String lastName, String fatherName, String email, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.fatherName = fatherName;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public void update(Employee source) {
        this.id = source.getId();
        this.name = source.getName();
        this.lastName = source.getLastName();
        this.fatherName = source.getFatherName();
        this.email = source.getEmail();
        this.phone = source.getPhone();
        this.note = source.getNote();
        this.company = source.getCompany();
        this.project = source.getProject();
    }


    @Override
    public Employee createNewInstance() {
        Employee newInstance = new Employee();
        newInstance.update(this);
        return newInstance;
    }
}
