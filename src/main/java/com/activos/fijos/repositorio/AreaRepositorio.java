package com.activos.fijos.repositorio;

import java.util.List;
import java.util.Optional;

import com.activos.fijos.entity.Area;

public interface AreaRepositorio {
	
	List<Area> getAll();
	Optional<Area> getByIdArea(long idArea);
	List<Area> save(List<Area> area);
	void delete(long idArea);
	Area modify(Area area);

}
