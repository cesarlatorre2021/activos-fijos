package com.activos.fijos.repositorio;

import java.util.List;
import java.util.Optional;

import com.activos.fijos.entity.Ubicacion;

public interface UbicacionRepositorio {
	
	List<Ubicacion> getAll();
	Optional<Ubicacion> getByIdBodega(long idUbicacion);
	Ubicacion save(Ubicacion ubicacion);
	void delete(long idUbicacion);
	void modify(Ubicacion ubicacion);

}
