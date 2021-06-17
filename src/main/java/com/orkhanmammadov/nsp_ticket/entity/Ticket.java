package com.orkhanmammadov.nsp_ticket.entity;

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
public class Ticket {

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


}
