package com.activos.fijos.repositorio;

import java.util.List;
import java.util.Optional;

import com.activos.fijos.entity.Persona;

public interface PersonaRepositorio {
	
	List<Persona> getAll();
	Optional<Persona> getByIdPersona(long idPersona);
	List<Persona> save(List<Persona> persona);
	void delete(long idPersona);
	Persona modify(Persona persona);

}
