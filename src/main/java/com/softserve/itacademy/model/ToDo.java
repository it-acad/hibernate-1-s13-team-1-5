package com.softserve.itacademy.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "todos")
public class ToDo {

    @Id
    @GeneratedValue(generator = "todo-sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "todo_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "20"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")
            })
    private long id;


    @Column(nullable = false, unique = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @NotBlank(message = "The title cannot be empty")
    @Column(nullable = false, unique = true)
    private String title;

    @OneToMany
    @JoinColumn(name = "todo_id")
    private Set<Task> tasks;


    @ManyToMany(mappedBy = "todosCollaborators")
    private Set<User> collaborators;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public ToDo() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<User> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(Set<User> collaborators) {
        this.collaborators = collaborators;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }


}

