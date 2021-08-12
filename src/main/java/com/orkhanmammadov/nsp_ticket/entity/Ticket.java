package com.orkhanmammadov.nsp_ticket.entity;

import com.orkhanmammadov.nsp_ticket.nsp_global.entity.GenericEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "ticket")
public class Ticket implements GenericEntity<Ticket> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "date_time")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTime;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "priority")
    private int priority;

    @Column(name = "status")
    private String status;

    @Column(name = "due_date")
    //@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dueDate;

    @ManyToOne()
    @JoinColumn(name = "fk_company")
    private Company company;

    @ManyToOne()
    @JoinColumn(name = "fk_project")
    private Project project;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_ticket")
    private List<DbFile> files;

    public void addFile(DbFile theFiles){
        if(files == null) {
            files = new ArrayList<>();
        }

        files.add(theFiles);
    }

    @Override
    public void update(Ticket source) {
        this.id = source.getId();
        this.dateTime = source.getDateTime();
        this.title = source.getTitle();
        this.content = source.getContent();
        this.priority = source.getPriority();
        this.status = source.getStatus();
        this.dueDate = source.getDueDate();
        this.company = source.getCompany();
        this.project = source.getProject();
        this.files = source.getFiles();
    }


    @Override
    public Ticket createNewInstance() {
        Ticket newInstance = new Ticket();
        newInstance.update(this);
        return newInstance;
    }
}
