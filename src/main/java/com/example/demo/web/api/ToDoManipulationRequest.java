package com.example.demo.web.api;


public class ToDoManipulationRequest {
    private String what;
    private boolean completed;

    public ToDoManipulationRequest(){} //Standardkonstruktor hinzufügen, damit Jackson die Instanz der Klasse korrekt erstellen kann

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
    public ToDoManipulationRequest(String what, boolean completed) {
        this.what = what;
        this.completed = completed;
    }
}
