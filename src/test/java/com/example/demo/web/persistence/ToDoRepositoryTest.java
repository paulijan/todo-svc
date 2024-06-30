package com.example.demo.web.persistence;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class ToDoRepositoryTest {

    @Autowired
    private ToDoRepository toDoRepository;

    @BeforeEach
    void setUp() {
        // Löschen aller Einträge vor jedem Test
        toDoRepository.deleteAll();
    }

    @Test
    void testSaveAndFindAll() {
        // Erstellen und Speichern einer neuen ToDoEntity
        ToDoEntity toDoEntity = new ToDoEntity("Test ToDo", false, LocalDateTime.now());
        toDoRepository.save(toDoEntity);

        // Abrufen aller ToDoEntity-Einträge
        List<ToDoEntity> toDoEntities = toDoRepository.findAll();

        // Überprüfen, ob der gespeicherte Eintrag korrekt abgerufen wird
        assertThat(toDoEntities).hasSize(1);
        assertThat(toDoEntities.get(0).getWhat()).isEqualTo("Test ToDo");
        assertThat(toDoEntities.get(0).isCompleted()).isFalse();
    }
}
