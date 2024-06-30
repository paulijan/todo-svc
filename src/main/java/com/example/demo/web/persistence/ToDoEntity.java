package com.example.demo.web.persistence;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "todo")
public class ToDoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "what", nullable = false)
    private String what;

    @Column(name = "completed", nullable = false)
    private boolean completed;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Konstruktor, der 'what' und 'completed' initialisiert und 'createdAt' auf jetzt setzt
    public ToDoEntity(String what, boolean completed) {
        this.what = what;
        this.completed = completed;
        this.createdAt = LocalDateTime.now(); // Setzt das Erstellungsdatum auf jetzt
    }

    // Konstruktor, der 'what', 'completed' und 'createdAt' initialisiert
    public ToDoEntity(String what, boolean completed, LocalDateTime createdAt) {
        this.what = what;
        this.completed = completed;
        this.createdAt = createdAt;
    }

    protected ToDoEntity() {}

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
