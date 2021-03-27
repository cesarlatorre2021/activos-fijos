package com.activos.fijos.repositorio;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.activos.fijos.entity.Activos;

public interface ActivosRepositorio {
	
	List<Activos> getAll();
	Optional<Activos> getByIdActivos(long idActivos);
	Optional<Activos> getByTipoActivo(String tipoActivo);
	Optional<Activos> getBySerialActivo(String serialActivo);
	Optional<List<Activos>> getByFechaActivo(LocalDateTime fechaActivo);
	void delete(long idActivos);
	Activos modify(Activos activos);
	List<Activos> save(List<Activos> activos);

}
