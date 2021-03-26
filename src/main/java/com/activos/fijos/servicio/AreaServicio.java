package com.activos.fijos.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activos.fijos.entity.Area;
import com.activos.fijos.repositorio.AreaRepositorio;

@Service
public class AreaServicio {

	@Autowired
	private AreaRepositorio areaRepositorio;
	
	public List<Area> getAll() {
        return areaRepositorio.getAll();
    }
	
	public Optional<Area> getByIdArea(long idArea) {
        return areaRepositorio.getByIdArea(idArea);
    }
	
	public List<Area> save(List<Area> area) {
        return areaRepositorio.save(area);
    }

    public boolean delete(long idArea) {
    	if (getByIdArea(idArea).isPresent() == true) {
    		areaRepositorio.delete(idArea);
    		return true;
    	}else {
    		return false;
    	}   	
    }
    
    public Area modify(Area save) {
        return areaRepositorio.modify(save);
    }

}
