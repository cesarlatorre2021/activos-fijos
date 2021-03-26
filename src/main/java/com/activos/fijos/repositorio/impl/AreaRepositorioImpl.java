package com.activos.fijos.repositorio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activos.fijos.entity.Area;
import com.activos.fijos.persistencia.crud.AreaCrudRepositorio;
import com.activos.fijos.repositorio.AreaRepositorio;

@Repository
public class AreaRepositorioImpl implements AreaRepositorio {
	
	@Autowired
	private AreaCrudRepositorio areaCrudRepositorio;

	@Override
	public List<Area> getAll() {
		return (List<Area>) areaCrudRepositorio.findAll();
	}

	@Override
	public Optional<Area> getByIdArea(long idArea) {
		return areaCrudRepositorio.listarAreaID(idArea);
	}

	@Override
	public List<Area> save(List<Area> area) {
		return (List<Area>) areaCrudRepositorio.saveAll(area);
	}

	@Override
	public void delete(long idArea) {
		areaCrudRepositorio.deleteForId(idArea);
	}

	@Override
	public Area modify(Area area) {
		areaCrudRepositorio.modificarProducto(area.getNombreArea(), area.getTelefonoContacto(), area.getIdArea());
		return area;
	}

}
