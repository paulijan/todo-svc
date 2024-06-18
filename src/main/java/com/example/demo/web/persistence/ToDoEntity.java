package com.example.demo.web.persistence;

import jakarta.persistence.*;

@Entity(name = "todo")
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "what", nullable = false)
    private String what;


    public ToDoEntity(String what) {
        this.what = what;
    }

    protected ToDoEntity() {}

    public Long getId() {
        return id;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }




}


