package com.example.demo.web.service;

import com.example.demo.web.api.ToDo;
import com.example.demo.web.persistence.ToDoEntity;
import com.example.demo.web.persistence.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }
    public List<ToDo> findAll(){
        List<ToDoEntity> todo = toDoRepository.findAll();
        return todo.stream()
                .map(toDoEntity -> new ToDo(
                        toDoEntity.getId(),
                        toDoEntity.getWhat()
                ))
                .collect(Collectors.toList());
    }
}
