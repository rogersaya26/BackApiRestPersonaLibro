package com.apiapp.apirest.services;

import java.util.List;

public interface BaseService<E> {
	//vamos a poder implementar esta interfaz de tipo generica<E> recibe cualquier entidad que podamos pasarle
	//y podemos usar sus metodos en este caso CRUD
	
	
	//este metodo no arroja ningun parametro trae una lista y arroja excepciones
	public List<E> findAll() throws Exception;
	
	//Obtener trae de la entidad en este caso persona de acuerdo al id que le pases
	public E findById(Long id) throws Exception;
	
	//crear una nueva entidad y para eso se envia una nueva entidad al repositorio
	public E save(E entity) throws Exception;
	
	//actualiza a base del id que le pasemos
	public E update(Long id, E entity) throws Exception;
	
	//eliminar un registro de la base de datos
	public boolean delete(Long id) throws Exception;
	
	//crear una clase en Services persona para implementar esta interfaz  

}