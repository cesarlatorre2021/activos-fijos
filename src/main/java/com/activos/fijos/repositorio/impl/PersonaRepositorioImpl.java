package com.activos.fijos.repositorio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activos.fijos.entity.Persona;
import com.activos.fijos.persistencia.crud.PersonaCrudRepositorio;
import com.activos.fijos.repositorio.PersonaRepositorio;

@Repository
public class PersonaRepositorioImpl implements PersonaRepositorio {
	
	@Autowired
	private PersonaCrudRepositorio personaCrudRepositorio;

	@Override
	public List<Persona> getAll() {
		return (List<Persona>) personaCrudRepositorio.findAll();
	}

	@Override
	public Optional<Persona> getByIdPersona(long idPersona) {
		return personaCrudRepositorio.listarPersonaID(idPersona);
	}

	@Override
	public List<Persona> save(List<Persona> persona) {
		return (List<Persona>) personaCrudRepositorio.saveAll(persona);
	}

	@Override
	public void delete(long idPersona) {
		personaCrudRepositorio.deleteForId(idPersona);
	}

	@Override
	public Persona modify(Persona persona) {
		personaCrudRepositorio.modificarProducto(persona.getTipoDocumento(), 
				                                 persona.getNumeroDocumento(), 
				                                 persona.getPrimerNombre(), 
				                                 persona.getSegundoNombre(), 
				                                 persona.getPrimerApellido(), 
				                                 persona.getSegundoApellido(), 
				                                 persona.getTelefonoContacto(), 
				                                 persona.getIdPersona());
		return persona;
	}

}
