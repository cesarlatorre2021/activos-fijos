package com.activos.fijos.repositorio;

import java.util.List;
import java.util.Optional;

import com.activos.fijos.entity.Ubicacion;

public interface UbicacionRepositorio {
	
	List<Ubicacion> getAll();
	Optional<Ubicacion> getByIdUbicacion(long idUbicacion);
	List<Ubicacion> save(List<Ubicacion> ubicacion);
	void delete(long idUbicacion);
	Ubicacion modify(Ubicacion ubicacion);

}
