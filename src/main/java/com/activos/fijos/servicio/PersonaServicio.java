package com.activos.fijos.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activos.fijos.entity.Persona;
import com.activos.fijos.repositorio.PersonaRepositorio;

@Service
public class PersonaServicio {
	
	@Autowired
	private PersonaRepositorio personaRepositorio;
	
	public List<Persona> getAll() {
        return personaRepositorio.getAll();
    }
	
	public Optional<Persona> getByIdPersona(long idPersona) {
        return personaRepositorio.getByIdPersona(idPersona);
    }
	
	public List<Persona> save(List<Persona> persona) {
        return personaRepositorio.save(persona);
    }

    public boolean delete(long idPersona) {
    	if (getByIdPersona(idPersona).isPresent() == true) {
    		personaRepositorio.delete(idPersona);
    		return true;
    	}else {
    		return false;
    	}   	
    }
    
    public Persona modify(Persona save) {
        return personaRepositorio.modify(save);
    }

}
