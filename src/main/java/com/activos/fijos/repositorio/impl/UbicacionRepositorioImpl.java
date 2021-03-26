package com.activos.fijos.repositorio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activos.fijos.entity.Ubicacion;
import com.activos.fijos.persistencia.crud.UbicacionCrudRepositorio;
import com.activos.fijos.repositorio.UbicacionRepositorio;

@Repository
public class UbicacionRepositorioImpl implements UbicacionRepositorio {
	
	@Autowired
	private UbicacionCrudRepositorio ubicacionCrudRepositorio;

	@Override
	public List<Ubicacion> getAll() {
		return (List<Ubicacion>) ubicacionCrudRepositorio.findAll();
	}

	@Override
	public Optional<Ubicacion> getByIdUbicacion(long idUbicacion) {
		return ubicacionCrudRepositorio.listarAreaID(idUbicacion);
	}

	@Override
	public void delete(long idUbicacion) {
		ubicacionCrudRepositorio.deleteForId(idUbicacion);
	}

	@Override
	public Ubicacion modify(Ubicacion ubicacion) {
		ubicacionCrudRepositorio.modificarProducto(ubicacion.getNombreCiudad(), 
												   ubicacion.getNombrePais(),
												   ubicacion.getDireccion(), 
												   ubicacion.getTelefonoContacto(),
												   ubicacion.getIdUbicacion());
		return ubicacion;
	}

	@Override
	public List<Ubicacion> save(List<Ubicacion> ubicacion) {
		return  (List<Ubicacion>) ubicacionCrudRepositorio.saveAll(ubicacion);
	}

}
