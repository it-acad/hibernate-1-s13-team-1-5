package com.softserve.itacademy.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="todos")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();

    @Column(name = "title")
    @NotBlank
    private String title;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private User user;

    @OneToMany(mappedBy = "todo")
    private List<Task> task;

    @ManyToMany(mappedBy = "todo")
    private Set<User> users = new HashSet<>();

    public ToDo() {
    }

    public void setTask(List<Task> task) {
        this.task = task;
    }

    public List<Task> getTask() {
        return task;
    }

    public void setOwner(User user) {
        users.add(user);
    }


    public void setCreatedAt(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return created_at;
    }

    public String getTitle() {
        return title;
    }
}
