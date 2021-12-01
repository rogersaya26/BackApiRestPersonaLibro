package com.apiapp.apirest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiapp.apirest.Entities.Persona;
import com.apiapp.apirest.services.PersonaService;

//crear un metodo por cada metodo de service

@RestController
//da acceso a nuestra api desde distintos origenes
@CrossOrigin(origins = "*")
//asi llamamaremos este este recurso en plural
@RequestMapping(path = "api/v1/personas")
public class PersonaController {

	private PersonaService personaService;
	
	//inicializamos el constructor
	public PersonaController(PersonaService personaService) {
		this.personaService = personaService;
	}
	
	//metodos
	
	//metodo getALL corresponde con FindALL
	@GetMapping("")
	public ResponseEntity<?> getAll() {
		try {
			//en nuestro cuerpo si se encuentra base de datos persona se va a devolver la lista de esas personas
			return ResponseEntity.status(HttpStatus.OK).body(personaService.findAll());
		} catch (Exception e) {
			//return ResponseEntity en caso que salga algo mal
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	
	
	//getOne que va a corresponderce con findId 
	//una variable cambiante que va a estar dentro de la url
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long Id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personaService.findById(Id));
		} catch (Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	
	
	// Metodo Save que corresponde con el metodo Save de service
	//debo indicarle que persona viene en el cuerpo con RequestBody
	@PostMapping("") 
	public ResponseEntity<?> save(@RequestBody Persona entity) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personaService.save(entity));
		} catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Persona entity) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(personaService.update(id, entity));
		} catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	
	//metodo delete
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(personaService.delete(id));
		} catch (Exception e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente mas tarde.\"}");
		}
	}
	
}
