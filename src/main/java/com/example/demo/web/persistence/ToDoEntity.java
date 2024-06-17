package com.example.demo.web.persistence;

import jakarta.persistence.*;

@Entity(name = "todo")
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "to_do", nullable = false)
    private String todo;
    @Column(name = "done")
    private Boolean done;

    public ToDoEntity(Long id, String todo, Boolean done) {
        this.id = id;
        this.todo = todo;
        this.done = done;
    }

    protected ToDoEntity() {}

    public Long getId() {
        return id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public Boolean isDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}


