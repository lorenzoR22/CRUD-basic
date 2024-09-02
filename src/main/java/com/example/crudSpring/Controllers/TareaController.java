package com.example.crudSpring.Controllers;

import com.example.crudSpring.Entities.Tarea;
import com.example.crudSpring.Services.TareaServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TareaController {

    @Autowired
    private TareaServiceInterface tareaServiceInterface;

    @GetMapping("/tareas")
    public String getAllTareas(Model model){
        model.addAttribute("tareas", tareaServiceInterface.getAllTareas());
        return "index";
    }

    @GetMapping("/showFormAddTarea")
    public String showFormAddTarea(Model model){
        model.addAttribute("tarea", new Tarea());
        return "addTarea";
    }

    @PostMapping("/addTarea")
    public String addNote(@ModelAttribute("tarea") Tarea tarea){
        tareaServiceInterface.saveTarea(tarea);
        return "redirect:/tareas";
    }

    @GetMapping("/showFormUpdateTarea/{id}")
    public String showFormUpdateNote(@PathVariable("id")Long id,Model model){
        Tarea tarea = tareaServiceInterface.findById(id);
        model.addAttribute("tarea", tarea);
        return "updateTarea";
    }

    @PostMapping("/updateTarea")
    public String updateNote(@ModelAttribute("tarea") Tarea tarea){
        tareaServiceInterface.updateTarea(tarea);
        return "redirect:/tareas";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id")Long id){
        tareaServiceInterface.deleteTarea(id);
        return "redirect:/tareas";
    }

}
