package com.example.demo.web;

import com.example.demo.web.api.ToDo;
import com.example.demo.web.api.ToDoManipulationRequest;
import com.example.demo.web.service.ToDoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ToDoRestController.class)
public class ToDoRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToDoService toDoService;

    private ToDo toDo;

    @BeforeEach
    void setUp() {
        toDo = new ToDo(1L, "Test ToDo", false);
    }

    @Test
    void fetchToDos() throws Exception {
        List<ToDo> todos = Arrays.asList(toDo);
        when(toDoService.findAll()).thenReturn(todos);

        mockMvc.perform(get("/api/v1/todos"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id").value(toDo.getId()))
                .andExpect(jsonPath("$[0].what").value(toDo.getWhat()))
                .andExpect(jsonPath("$[0].completed").value(toDo.isCompleted()));
    }

    @Test
    void fetchToDobyId() throws Exception {
        when(toDoService.findById(anyLong())).thenReturn(toDo);

        mockMvc.perform(get("/api/v1/todos/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(toDo.getId()))
                .andExpect(jsonPath("$.what").value(toDo.getWhat()))
                .andExpect(jsonPath("$.completed").value(toDo.isCompleted()));
    }

    @Test
    void createToDo() throws Exception {
        ToDoManipulationRequest request = new ToDoManipulationRequest("New ToDo", false);

        when(toDoService.create(any(ToDoManipulationRequest.class))).thenReturn(toDo);

        mockMvc.perform(post("/api/v1/todos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"what\": \"New ToDo\", \"completed\": false}"))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", "/api/v1/todos/" + toDo.getId()));
    }

    @Test
    void updateToDo() throws Exception {
        ToDoManipulationRequest request = new ToDoManipulationRequest("Updated ToDo", true);

        when(toDoService.update(anyLong(), any(ToDoManipulationRequest.class))).thenReturn(toDo);

        mockMvc.perform(put("/api/v1/todos/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"what\": \"Updated ToDo\", \"completed\": true}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(toDo.getId()))
                .andExpect(jsonPath("$.what").value(toDo.getWhat()))
                .andExpect(jsonPath("$.completed").value(toDo.isCompleted()));
    }

    @Test
    void deleteToDo() throws Exception {
        when(toDoService.deleteById(anyLong())).thenReturn(true);
        mockMvc.perform(delete("/api/v1/todos/{id}", 1L))
                .andExpect(status().isOk());
    }
}
