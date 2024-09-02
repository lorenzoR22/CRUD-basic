package com.example.crudSpring.Repositories;

import com.example.crudSpring.Entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Long>{

}
