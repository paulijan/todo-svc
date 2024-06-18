package com.example.demo.web.api;


public class ToDoManipulationRequest {
    private String what;

    public ToDoManipulationRequest(){} //Standardkonstruktor hinzufügen, damit Jackson die Instanz der Klasse korrekt erstellen kann

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public ToDoManipulationRequest(String what) {
        this.what = what;
    }
}
