package com.example.demo.web.service;

import com.example.demo.web.api.ToDo;
import com.example.demo.web.api.ToDoManipulationRequest;
import com.example.demo.web.persistence.ToDoEntity;
import com.example.demo.web.persistence.ToDoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ToDoServiceTest {

    @Mock
    private ToDoRepository toDoRepository;

    @InjectMocks
    private ToDoService toDoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        ToDoEntity toDoEntity1 = new ToDoEntity("Test ToDo 1", false);
        toDoEntity1.setId(1L); // Manuell ID setzen
        ToDoEntity toDoEntity2 = new ToDoEntity("Test ToDo 2", true);
        toDoEntity2.setId(2L); // Manuell ID setzen

        when(toDoRepository.findAll()).thenReturn(Arrays.asList(toDoEntity1, toDoEntity2));

        List<ToDo> todos = toDoService.findAll();

        assertThat(todos).hasSize(2);
        verify(toDoRepository, times(1)).findAll();
    }

    @Test
    void testFindById() {
        ToDoEntity toDoEntity = new ToDoEntity("Test ToDo", false);
        toDoEntity.setId(1L); // Manuell ID setzen

        when(toDoRepository.findById(1L)).thenReturn(Optional.of(toDoEntity));

        ToDo todo = toDoService.findById(1L);

        assertThat(todo).isNotNull();
        assertThat(todo.getId()).isEqualTo(1L);
        verify(toDoRepository, times(1)).findById(1L);
    }

    @Test
    void testCreate() {
        ToDoManipulationRequest request = new ToDoManipulationRequest("New ToDo", true);
        ToDoEntity toDoEntity = new ToDoEntity(request.getWhat(), request.isCompleted());
        toDoEntity.setId(1L); // Manuell ID setzen

        when(toDoRepository.save(any(ToDoEntity.class))).thenReturn(toDoEntity);

        ToDo createdToDo = toDoService.create(request);

        assertThat(createdToDo).isNotNull();
        assertThat(createdToDo.getId()).isEqualTo(1L);
        verify(toDoRepository, times(1)).save(any(ToDoEntity.class));
    }

    @Test
    void testUpdate() {
        ToDoManipulationRequest request = new ToDoManipulationRequest("Updated ToDo", true);
        ToDoEntity toDoEntity = new ToDoEntity("Test ToDo", false);
        toDoEntity.setId(1L); // Manuell ID setzen

        when(toDoRepository.findById(1L)).thenReturn(Optional.of(toDoEntity));
        when(toDoRepository.save(any(ToDoEntity.class))).thenReturn(toDoEntity);

        ToDo updatedToDo = toDoService.update(1L, request);

        assertThat(updatedToDo).isNotNull();
        assertThat(updatedToDo.getId()).isEqualTo(1L);
        assertThat(updatedToDo.getWhat()).isEqualTo("Updated ToDo");
        assertThat(updatedToDo.isCompleted()).isTrue();
        verify(toDoRepository, times(1)).findById(1L);
        verify(toDoRepository, times(1)).save(any(ToDoEntity.class));
    }
}
