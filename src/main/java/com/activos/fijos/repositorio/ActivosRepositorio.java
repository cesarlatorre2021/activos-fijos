package com.activos.fijos.repositorio;

import java.util.List;
import java.util.Optional;

import com.activos.fijos.entity.Activos;

public interface ActivosRepositorio {
	
	List<Activos> getAll();
	Optional<Activos> getByIdActivos(long idActivos);
	Activos save(Activos activos);
	void delete(long idActivos);
	void modify(Activos activos);

}
