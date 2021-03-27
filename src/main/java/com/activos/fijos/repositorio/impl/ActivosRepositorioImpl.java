package com.activos.fijos.repositorio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activos.fijos.entity.Activos;
import com.activos.fijos.persistencia.crud.ActivosCrudRepositorio;
import com.activos.fijos.repositorio.ActivosRepositorio;

@Repository
public class ActivosRepositorioImpl implements ActivosRepositorio{
	
	@Autowired
	private ActivosCrudRepositorio activosCrudRepositorio;

	@Override
	public List<Activos> getAll() {
		return (List<Activos>) activosCrudRepositorio.findAll();
	}

	@Override
	public Optional<Activos> getByIdActivos(long idActivos) {
		return activosCrudRepositorio.listarActivosID(idActivos);
	}

	@Override
	public List<Activos> save(List<Activos> activos) {
		return (List<Activos>) activosCrudRepositorio.saveAll(activos);
	}

	@Override
	public void delete(long idActivos) {
		activosCrudRepositorio.deleteForId(idActivos);
	}

	@Override
	public Activos modify(Activos activos) {
		activosCrudRepositorio.modificarProducto(activos.getNombre(), 
				                                 activos.getDescripcion(), 
				                                 activos.getTipo(), 
				                                 activos.getSerial(), 
				                                 activos.getNumeroInventario(), 
				                                 activos.getPeso(),
				                                 activos.getAlto(), 
				                                 activos.getAncho(), 
				                                 activos.getLargo(), 
				                                 activos.getValorCompra(), 
				                                 activos.getIdActivo());
		return activos;
	}

}
