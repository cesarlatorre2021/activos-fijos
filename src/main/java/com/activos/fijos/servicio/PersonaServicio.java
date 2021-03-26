package com.activos.fijos.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activos.fijos.entity.Persona;

@Service
public class PersonaServicio {
	
	@Autowired
	private PersonaServicio personaServicio;
	
	public List<Persona> getAll() {
        return personaServicio.getAll();
    }
	
	public Optional<Persona> getByIdPersona(long idPersona) {
        return personaServicio.getByIdPersona(idPersona);
    }
	
	public Persona save(Persona persona) {
        return personaServicio.save(persona);
    }

    public boolean delete(long idPersona) {
    	if (getByIdPersona(idPersona).isPresent() == true) {
    		personaServicio.delete(idPersona);
    		return true;
    	}else {
    		return false;
    	}   	
    }
    
    public Persona modify(Persona save) {
        return personaServicio.save(save);
    }

}
