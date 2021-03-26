package com.activos.fijos.repositorio;

import java.util.List;
import java.util.Optional;

import com.activos.fijos.entity.Area;
import com.activos.fijos.entity.Persona;

public interface PersonaRepositorio {
	
	List<Persona> getAll();
	Optional<Area> getByIdPersona(long idPersona);
	Area save(Persona persona);
	void delete(long idPersona);
	void modify(Persona persona);

}
