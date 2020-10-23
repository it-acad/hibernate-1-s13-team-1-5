package com.softserve.itacademy.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "states")
public class State {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @OneToMany(mappedBy = "task")
    private List<Task> tasks;

    public State() {
    }

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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "State{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
