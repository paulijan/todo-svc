package com.example.demo;

import com.example.demo.web.api.ToDo;
import com.example.demo.web.api.ToDoManipulationRequest;
import com.example.demo.web.persistence.ToDoEntity;
import com.example.demo.web.persistence.ToDoRepository;
import com.example.demo.web.service.ToDoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApplicationTests {

	@Autowired
	private ToDoService toDoService;

	@Autowired
	private ToDoRepository toDoRepository;

	@BeforeEach
	void setUp() {
		toDoRepository.deleteAll(); // löscht alle Einträge vor jedem Test
	}

	@Test
	void shouldCreateAndFetchToDo() {
		ToDoManipulationRequest request = new ToDoManipulationRequest("Test", false);
		ToDo createdToDo = toDoService.create(request);

		assertThat(createdToDo).isNotNull();
		assertThat(createdToDo.getWhat()).isEqualTo("Test");

		ToDo fetchedToDo = toDoService.findById(createdToDo.getId());
		assertThat(fetchedToDo).isNotNull();
		assertThat(fetchedToDo.getWhat()).isEqualTo("Test");
	}

	@Test
	void shouldFindAllToDos() {
		LocalDateTime now = LocalDateTime.now();
		toDoRepository.save(new ToDoEntity("Test 1", false, now));
		toDoRepository.save(new ToDoEntity("Test 2", true, now));

		List<ToDo> todos = toDoService.findAll();
		assertThat(todos).hasSize(2);
	}
}
