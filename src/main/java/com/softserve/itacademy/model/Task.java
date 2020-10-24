package com.softserve.itacademy.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name="tasks")
public class Task {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @Size(min = 3,max = 200)
    private String name;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToOne(optional = false)
    @JoinColumn(name="state_id")
    private State state;

    @ManyToMany
    @JoinColumn(name="todo_id")
    private List<ToDo> todo;

    public Task() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public List<ToDo> getTodo() {
        return todo;
    }

    public void setTodo(List<ToDo> todo) {
        this.todo = todo;
    }
}
