package com.example.demo.web.service;

import com.example.demo.web.api.ToDo;
import com.example.demo.web.api.ToDoManipulationRequest;
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
        List<ToDoEntity> todo = toDoRepository.findAll(); //wenden an den Controller
        return todo.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public ToDo findById(Long id){
        var toDoEntity = toDoRepository.findById(id);
        return toDoEntity.isPresent()? transformEntity(toDoEntity.get()) : null;
    }


    public ToDo create(ToDoManipulationRequest request) {
        var toDoEntity = new ToDoEntity(request.getWhat());
        toDoEntity = toDoRepository.save(toDoEntity); //save gibt ein s zurück (generischer Typ) richtet sich nach dem was man in () reingibt
        // ab dieser Zeile steht die Id für todofest
        return transformEntity(toDoEntity);
    }
    public ToDo update(Long id, ToDoManipulationRequest request){
        var toDoEntityOptional = toDoRepository.findById(id);
        if (toDoEntityOptional.isEmpty()) { // gibt es zu der Id einen Datensatz?
            return null;
        }

        var toDoEntity = toDoEntityOptional.get(); // holen die toDoEntity auf Optional rausholen
        toDoEntity.setWhat(request.getWhat()); // Aktualisiert vom Client (DB weiß hier noch nichts davon)
        toDoEntity = toDoRepository.save(toDoEntity); // Übermittlung an DB

        return transformEntity(toDoEntity);
    }
    public boolean deleteById(Long id){
        if (!toDoRepository.existsById(id)){
            return false;
        }

        toDoRepository.deleteById(id);
        return true;
    }

    private ToDo transformEntity(ToDoEntity toDoEntity){  //Macht eine Entity in eine 'Tod.o //ZURÜCKMAPPEN
        return new ToDo(
                toDoEntity.getId(),
                toDoEntity.getWhat()
        );
    }
}
