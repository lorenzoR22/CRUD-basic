package com.example.crudSpring.Services;

import com.example.crudSpring.Entities.Tarea;

import java.util.List;

public interface TareaServiceInterface {
    public Tarea saveTarea(Tarea tarea);
    public List<Tarea> getAllTareas();
    public Tarea updateTarea(Tarea tarea);
    public Tarea findById(Long id);
    public boolean deleteTarea(Long id);
}
