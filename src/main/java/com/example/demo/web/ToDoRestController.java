package com.example.demo.web;

import com.example.demo.web.api.ToDo;
import com.example.demo.web.api.ToDoManipulationRequest;
import com.example.demo.web.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class ToDoRestController {

    private final ToDoService toDoService;

    public ToDoRestController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }


    @CrossOrigin
    @GetMapping(path = "/api/v1/todos")  //Lesende Anfrage
    public ResponseEntity<List<ToDo>> fetchToDos(){         // Empfängt den Request
        return ResponseEntity.ok(toDoService.findAll());  //Mapping findet nicht mehr statt, es wird zum Service deligiert
    }
    @CrossOrigin
   @GetMapping(path = "/api/v1/todos/{id}")
   public ResponseEntity<ToDo> fetchToDobyId(@PathVariable Long id){
        var toDo = toDoService.findById(id);
        return toDo != null? ResponseEntity.ok(toDo) : ResponseEntity.notFound().build(); // Bei keinem Eintrag in der DB notFound
   }

    @CrossOrigin
    @PostMapping(path = "/api/v1/todos")  //Schreibende Anfrage
    public ResponseEntity<Void> createToDo(@RequestBody ToDoManipulationRequest request) throws URISyntaxException {  //Neue "Ressource" wird erstellt und unter welcher Uri ist sie erreichbar
        var toDo =  toDoService.create(request);             //Wird über Header zurück gesendet und nicht über Responsebody deshalb ist er leer (Void)
        URI uri = new URI("/api/v1/todos/" + toDo.getId());  //"Adresse" der neu erzeugten Ressource
        return ResponseEntity.created(uri).build();
    }
    @CrossOrigin
    @PutMapping(path = "/api/v1/todos/{id}") //Update
    public ResponseEntity<ToDo> updateToDo(@PathVariable Long id, @RequestBody ToDoManipulationRequest request) { //Aktualisiert zurück
        var toDo = toDoService.update(id, request);
        return toDo != null? ResponseEntity.ok(toDo) : ResponseEntity.notFound().build(); // Bei keinem Eintrag in der DB notFound
    }

    @CrossOrigin
    @DeleteMapping(path = "/api/v1/todos/{id}")
    public ResponseEntity<Void> deleteToDo(@PathVariable Long id){  //Void da gelöschter "Eintrag" es soll/wird nichts angezeigt
        boolean successful = toDoService.deleteById(id);
        return successful? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}
