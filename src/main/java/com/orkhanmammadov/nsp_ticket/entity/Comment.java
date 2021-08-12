package com.orkhanmammadov.nsp_ticket.entity;

import com.orkhanmammadov.nsp_ticket.nsp_global.entity.GenericEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "comment")
public class Comment implements GenericEntity<Comment> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "date_time")
    private LocalDateTime dateTime;


    private String comment;

    @Column(name = "created_by")
    private String createdBy;

    @ManyToOne
    @JoinColumn(name = "fk_ticket")
    private Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "fk_employee")
    private Employee employee;

    @Override
    public void update(Comment source) {
        this.id = source.getId();
        this.comment = source.getComment();
        this.dateTime = source.getDateTime();
        this.createdBy = source.getCreatedBy();
        this.ticket = source.getTicket();
        this.employee = source.getEmployee();
    }

    @Override
    public Comment createNewInstance() {
        Comment newInstance = new Comment();
        newInstance.update(this);
        return newInstance;
    }
}
