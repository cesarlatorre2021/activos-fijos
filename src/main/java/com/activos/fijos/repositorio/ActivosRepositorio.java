package com.activos.fijos.repositorio;

import java.util.List;
import java.util.Optional;

import com.activos.fijos.entity.Activos;

public interface ActivosRepositorio {
	
	List<Activos> getAll();
	Optional<Activos> getByIdActivos(long idActivos);
	void delete(long idActivos);
	Activos modify(Activos activos);
	List<Activos> save(List<Activos> activos);

}
