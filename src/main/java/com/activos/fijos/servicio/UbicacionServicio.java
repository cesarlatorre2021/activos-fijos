package com.activos.fijos.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activos.fijos.entity.Ubicacion;
import com.activos.fijos.repositorio.UbicacionRepositorio;

@Service
public class UbicacionServicio {
	
	@Autowired
	private UbicacionRepositorio ubicacionRepositorio;
	
	public List<Ubicacion> getAll() {
        return ubicacionRepositorio.getAll();
    }
	
	public Optional<Ubicacion> getByIdBodega(long idUbicacion) {
        return ubicacionRepositorio.getByIdBodega(idUbicacion);
    }
	
	public Ubicacion save(Ubicacion bodega) {
        return ubicacionRepositorio.save(bodega);
    }

    public boolean delete(long idUbicacion) {
    	if (getByIdBodega(idUbicacion).isPresent() == true) {
    		ubicacionRepositorio.delete(idUbicacion);
    		return true;
    	}else {
    		return false;
    	}   	
    }
    
    public Ubicacion modify(Ubicacion save) {
        return ubicacionRepositorio.save(save);
    }

}
