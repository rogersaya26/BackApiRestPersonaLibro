package com.apiapp.apirest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apiapp.apirest.Entities.Persona;


//recibe la entidad que declaramos y el tipo de ID que declaramos
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

}
