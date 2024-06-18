package com.example.demo.web;

import com.example.demo.web.api.ToDo;
import com.example.demo.web.persistence.ToDoRepository;
import com.example.demo.web.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoRestController {

    private final ToDoService toDoService;

    public ToDoRestController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }


    @GetMapping(path = "/api/v1/todos")
    public ResponseEntity<List<ToDo>> fetchToDos(){
        return ResponseEntity.ok(toDoService.findAll());
    }
}
