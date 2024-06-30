package com.example.demo.web.api;

public class ToDo {

    private long id;
    private String what;
    private boolean completed;

    public ToDo(long id, String what, boolean completed) {
        this.id = id;
        this.what = what;
        this.completed = completed;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
}
