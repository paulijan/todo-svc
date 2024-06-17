package com.example.demo.web;

import com.example.demo.web.api.ToDo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ToDoRestController {

    private List<ToDo> todo;

    public ToDoRestController(){
        todo = new ArrayList<>();
        todo.add(new ToDo(1, "aufräumen", false));
        todo.add(new ToDo(2, "Arzttermin", true));
        todo.add(new ToDo(3, "kochen", true));
    }

    @GetMapping(path = "/api/v1/todos")
    public List<ToDo> fetchToDos(){
        return todo;
    }
}
