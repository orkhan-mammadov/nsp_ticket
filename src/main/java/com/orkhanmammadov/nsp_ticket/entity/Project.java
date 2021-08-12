package com.orkhanmammadov.nsp_ticket.entity;

import com.orkhanmammadov.nsp_ticket.nsp_global.entity.GenericEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "project")
public class Project implements GenericEntity<Project> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "short_name")
    private String shortName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "fk_company")
    private Company company;

    @Override
    public void update(Project source) {
        this.id = source.getId();
        this.name = source.getName();
        this.shortName = source.getShortName();
        this.company = source.getCompany();
    }


    @Override
    public Project createNewInstance() {
        Project newInstance = new Project();
        newInstance.update(this);
        return newInstance;
    }
}
