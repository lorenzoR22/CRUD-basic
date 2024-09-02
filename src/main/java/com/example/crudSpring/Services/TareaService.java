package com.example.crudSpring.Services;

import com.example.crudSpring.Entities.Tarea;
import com.example.crudSpring.Repositories.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TareaService implements TareaServiceInterface {

    @Autowired
    private TareaRepository tareaRepository;

    public Tarea saveTarea(Tarea tarea){
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        tarea.setFecha(LocalDateTime.now().format(formatter));
        return tareaRepository.save(tarea);
    }

    public List<Tarea> getAllTareas(){
        return tareaRepository.findAll();
    }

    public Tarea updateTarea(Tarea tarea){
        Tarea tareaExits = tareaRepository.findById(tarea.getId())
                .orElseThrow(()->new RuntimeException("no se encontro la nota"));

        tareaExits.setId(tarea.getId());
        tareaExits.setNombre(tarea.getNombre());
        tareaExits.setDescripcion(tarea.getDescripcion());
        tareaExits.setFecha(tarea.getFecha());

        return tareaRepository.save(tareaExits);
    }

    public Tarea findById(Long id){
         return tareaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro la nota"));
    }

    public boolean deleteTarea(Long id){
        boolean noteExists= tareaRepository.existsById(id);
        if(noteExists){
            tareaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
