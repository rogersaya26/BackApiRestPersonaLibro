package com.apiapp.apirest.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import com.apiapp.apirest.Entities.Persona;
import com.apiapp.apirest.repositories.PersonaRepository;

public class PersonaService implements BaseService<Persona> {

	
	//hacemos implementacion de entidadRepositorio
	@Autowired
	private PersonaRepository personaRepository;
	//constructor y autowired
	//este constructor no se llama de ningun lado JPA se encarga de el
	//tambien se puede ahorrar escribiendo @autowires
	public PersonaService(PersonaRepository personaRepository) {
		this.personaRepository = personaRepository;
	}
	
	
	//aqui implementamos todos los metodos de la interfaz
	@Override
	@Transactional
	public List<Persona> findAll() throws Exception {
		try{
			List<Persona> entities = personaRepository.findAll();
				return entities;	
		} catch (Exception e) {
				 throw new Exception(e.getMessage());
			 }
	}

	@Override
	@Transactional
	public Persona findById(Long id) throws Exception {
		try{
			Optional<Persona> entityOptional = personaRepository.findById(id);
			return entityOptional.get();
		} catch (Exception e) {
			throw new Exception(e.getMessage());
			 }
	}

	@Override
	@Transactional
	public Persona save(Persona entity) throws Exception {
		try{
			entity = personaRepository.save(entity);
			return entity;
		} catch (Exception e) {
				throw new Exception(e.getMessage());
			 }
	}

	@Override
	@Transactional
	public Persona update(Long id, Persona entity) throws Exception {
		try{
			Optional<Persona> entityOptional = personaRepository.findById(id);
			Persona persona = entityOptional.get();
			persona = personaRepository.save(persona);
			return persona;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
			 }
	}

	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		try{
			if (personaRepository.existsById(id)) {
				personaRepository.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
				 throw new Exception (e.getMessage()); 
					 
				 
			 }

	}
}
